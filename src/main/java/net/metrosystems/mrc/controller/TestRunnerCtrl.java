package net.metrosystems.mrc.controller;

import io.cucumber.core.cli.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class TestRunnerCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(TestRunnerCtrl.class);
    private static final TestingStatus TESTING_STATUS = new TestingStatus();

    @RequestMapping(method = RequestMethod.GET, path = "stopTests", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> abortTesting(
        @RequestParam(value = "stop", required = false, defaultValue = "false") boolean stopMigration) {
        if (stopMigration) {
            synchronized (TESTING_STATUS) {
                if (TESTING_STATUS.getStatus() == TestingStatus.State.IN_PROGRESS) {
                    TESTING_STATUS.setState(TestingStatus.State.INTERRUPTED);
                    return ResponseEntity.ok("Testing marked as to be interrupted");
                } else {
                    return ResponseEntity.ok("There is no active testing in process");
                }
            }
        } else {
            return ResponseEntity.ok("Use 'stop=true' to interrupt testing process");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "testingStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getMigrationStatus() {
        return new ResponseEntity<>(TESTING_STATUS.toMap(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "testing", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> startTests() {
        LOG.info("Testing started at {}", new Date());
        CompletableFuture.runAsync(this::runTests);
        return new ResponseEntity<>("Started", HttpStatus.OK);
    }

    private boolean runTests() {
        try {
            TESTING_STATUS.setState(TestingStatus.State.IN_PROGRESS);
            Main.main(new String[] {
                "--glue",
                "net.metrosystems.mrc.seleniumcucumber.stepdefinitions",
                "features/"}
            );
            TESTING_STATUS.setState(TestingStatus.State.DONE);
        } catch (Exception e) {
            TESTING_STATUS.addException(e);
            LOG.error("Exception ", e);
            return false;
        }
        return true;
    }
}
