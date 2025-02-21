package com.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    private final Map<Long,String> memos=new HashMap<Long,String>();
    private final AtomicLong counter=new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> creatMemo(@RequestBody String content) {
        Long id=counter.incrementAndGet();
        memos.put(id,content);
        return ResponseEntity.ok(id);
    }
    @GetMapping
    public ResponseEntity<Map<Long,String>> getMemos() {
        return ResponseEntity.ok(memos);
    }
}
