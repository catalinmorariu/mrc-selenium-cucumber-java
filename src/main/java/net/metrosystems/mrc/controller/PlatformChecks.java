package net.metrosystems.mrc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

@RestController
public class PlatformChecks {

    private static final Logger LOG = LoggerFactory.getLogger(PlatformChecks.class);
    private static final ResponseEntity<String> NO_CONTENT = new ResponseEntity<>(HttpStatus.NO_CONTENT);

    @RequestMapping(value = {"/.well-known/live"}, method = {GET, HEAD})
    public ResponseEntity<String> live() {
        LOG.debug("/.well-known/live -> 204");
        return NO_CONTENT;
    }

    @RequestMapping(value = {"/.well-known/ready"}, method = {GET, HEAD})
    public ResponseEntity<String> ready() {
        LOG.debug("/.well-known/ready -> 204");
        return NO_CONTENT;
    }
}
