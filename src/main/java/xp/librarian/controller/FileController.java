package xp.librarian.controller;

import java.io.*;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import xp.librarian.utils.UploadUtils;

/**
 * @author xp
 */
@RestController
public class FileController {

    @GetMapping("/uploads/{filename:.+}/")
    public ResponseEntity getFile(@PathVariable String filename) {
        Resource res = new FileSystemResource(new File(UploadUtils.getPath(), filename));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
