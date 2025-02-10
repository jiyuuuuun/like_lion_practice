package com.example.friendapp.controller;

import com.example.friendapp.domain.Friend;
import com.example.friendapp.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor //@RequiredArgsConstructor는 final 필드나 @NonNull이 붙은 필드에 대해서만 생성자를 자동으로 만들어줌
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

//    @GetMapping("/list")
//    public String list(Model model) {
//        model.addAttribute("friends", friendService.findAllFriend());
//
//        return "friends/list";
//    };
    @GetMapping("/list")
    public String list(Model model,
                   @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                   @RequestParam(name = "size", required = false, defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page - 1, size);
        model.addAttribute("friends", friendService.findAllFriends(pageable));
        model.addAttribute("currentPage", page);
        return "friends/list";
}

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }
    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend, Model model){
        friendService.addFriend(friend);
        model.addAttribute("friends",friendService.findAllFriend());
        return "redirect:/friends/list";
    }
    @GetMapping("/{id}")
    public String edit(@PathVariable (name = "id") long id, Model model) {
        model.addAttribute("friend", friendService.findFriend(id));
        return "friends/detail";
    }
    @GetMapping("/update/{id}")
    public String friendUpdate(@PathVariable (name = "id") Long id, Model model) {
        model.addAttribute("friend", friendService.findFriend(id));
        return "friends/updateform";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (name = "id") long id, Model model) {
        friendService.deleteFriend(id);
        model.addAttribute("friends",friendService.findAllFriend());
        return "redirect:/friends/list";
    };
    @PostMapping("/edit")
    public String editFriend(@ModelAttribute Friend friend) {
        friendService.addFriend(friend);
        return "redirect:/friends/list";
    };

}
