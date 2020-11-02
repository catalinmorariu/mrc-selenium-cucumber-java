package net.metrosystems.mrc.controller;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cucumber.core.cli.Main;

@RestController
public class TestRunnerCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(TestRunnerCtrl.class);
    private static final TestingStatus TESTING_STATUS = new TestingStatus();

    @RequestMapping(method = RequestMethod.GET, path = "stopTests", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> abortTesting(
        @RequestParam(value = "stop", required = false, defaultValue = "false") boolean stopMigration) {
        if (stopMigration) {
            synchronized (TESTING_STATUS) {
                if (TESTING_STATUS.getState() == TestingStatus.State.IN_PROGRESS) {
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

    @RequestMapping(method = RequestMethod.GET, path = "testing", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> startTests() {
        LOG.info("Testing started at {}", new Date());
        CompletableFuture.runAsync(this::runTests);
        return new ResponseEntity<>("Started", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "testing-vlad", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> startTestsVlad() {
        LOG.info("Testing started at {}", new Date());
        this.runTests();
        return new ResponseEntity<>("Started", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "testing/reportsCheck", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> startSpecificTest() {
        LOG.info("Testing started at {}", new Date());
        this.runFirstTest();
        return new ResponseEntity<>("Started", HttpStatus.OK);
    }

    private void runFirstTest() {
        //System.setProperty("Headless", "true");
        Main.main(new String[] {
            "--glue",
            "net.metrosystems.mrc.seleniumcucumber.stepdefinitions",
            "features/001_Reports check.feature"}
        );
        //System.setProperty("Headless", "false");
        }

    private boolean runTests() {
        try {
            synchronized (TESTING_STATUS) {
                if (TESTING_STATUS.getState() != TestingStatus.State.IN_PROGRESS) {
                    TESTING_STATUS.setState(TestingStatus.State.IN_PROGRESS);
                    System.setProperty("Headless", "true");
                    byte result = Main.run(new String[] {
                        "--glue",
                        "net.metrosystems.mrc.seleniumcucumber.stepdefinitions",
                        "features/"}, Thread.currentThread().getContextClassLoader());
                    System.setProperty("Headless", "false");

                    LOG.info("result byte: {}", result);

                } else {
                    LOG.error("Another test is in progress");
                    return false;
                }
            }
            TESTING_STATUS.setState(TestingStatus.State.DONE);
        } catch (Exception e) {
            TESTING_STATUS.addException(e);
            LOG.error("Exception ", e);
            return false;
        }
        return true;
    }
}
