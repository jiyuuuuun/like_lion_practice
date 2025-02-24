package com.example.restexam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
@RequestMapping("/api2/Memos")
public class MemoRest2Controller {
    private final Map<Long,String> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public Long createMemo(@RequestBody String content) {
        log.info("📌 [POST] Received memo content: {}", content);

        Long id = counter.incrementAndGet();
        memos.put(id, content);

        log.info("✅ [POST] Memo saved with ID: {}, Content: {}", id, content);
        return id;
    }

    @GetMapping("/{id}")
    public String getMemo(@PathVariable("id") Long id) {
        if (!memos.containsKey(id)) {
            return "No memo found";
        }
        return memos.get(id);
    }

    @PutMapping("/{id}")
    public String updateMemo(@PathVariable("id") Long id, @RequestBody String content) {
        if (!memos.containsKey(id)) {
            return "Not found";
        }
        memos.put(id,content);
        return "메모 수정 완료";
    }


    @DeleteMapping("/{id}")
    public String deleteMemo(@PathVariable("id") Long id) {
        if (!memos.containsKey(id)) {
            return "Not found";
        }
        memos.remove(id);
        return "메모 수정 완료";
    }
}
