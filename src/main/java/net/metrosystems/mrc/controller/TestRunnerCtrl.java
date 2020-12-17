package net.metrosystems.mrc.controller;

import io.cucumber.core.cli.Main;
import net.metrosystems.mrc.KubernetesHeadlessRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController()
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

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "runAllTests", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> startTestsVlad() {
        LOG.info("Testing started at {}", new Date());
        boolean result = runAllTest();
        LOG.info("result: {}", result);
        return result ? new ResponseEntity<>("Passed", HttpStatus.OK) : new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.GET, path = "testing/reportsCheck", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> startSpecificTest() {
        LOG.info("Testing started at {}", new Date());
        String uuid = UUID.randomUUID().toString();
        this.runFirstTest(uuid);
        return new ResponseEntity<>(uuid, HttpStatus.OK);
    }

    private void runFirstTest(String uuid) {
        startProcess(
            "--plugin", "html:build/cucumber-reports_" + uuid + ".html",
            "features/");
    }

    private void startProcess(String... args) {
        try {
            String javaHome = System.getProperty("java.home");
            String javaBin = javaHome +
                File.separator + "bin" +
                File.separator + "java";
            String classpath = System.getProperty("java.class.path");
            String className = KubernetesHeadlessRunner.class.getCanonicalName();

            List<String> command = new LinkedList<>();
            command.add(javaBin);
            command.add("-cp");
            command.add(classpath);
            command.add(className);
            command.addAll(Arrays.asList(args));
            ProcessBuilder builder = new ProcessBuilder(command);

            Process process = builder.inheritIO().start();
            process.waitFor();
            LOG.info("exit value: {}", process.exitValue());
        } catch (Exception e) {
            LOG.error("Exception ", e);
        }
    }

    private boolean runAllTest() {
        return Main.run(new String[]{
            "features/"}, Thread.currentThread().getContextClassLoader()) == 0;
    }

//    private boolean runTests() {
//        byte result = 1;
//        try {
//            synchronized (TESTING_STATUS) {
//                if (TESTING_STATUS.getState() != TestingStatus.State.IN_PROGRESS) {
//                    TESTING_STATUS.setState(TestingStatus.State.IN_PROGRESS);
//                    System.setProperty("Headless", "true");
//                    result = Main.run(new String[] {
//                        "--glue",
//                        "net.metrosystems.mrc.seleniumcucumber.stepdefinitions",
//                        "features/"}, Thread.currentThread().getContextClassLoader());
////                    System.setProperty("Headless", "false");
//                } else {
//                    LOG.error("Another test is in progress");
//                    //return false;
//                }
//            }
//            TESTING_STATUS.setState(TestingStatus.State.DONE);
//        } catch (Exception e) {
//            TESTING_STATUS.addException(e);
//            LOG.error("Exception ", e);
//            //return false;
//        }
//        return result == 0 ? true : false;
//    }
}
