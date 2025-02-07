package com.example.friendapp.service;

import com.example.friendapp.domain.Friend;
import com.example.friendapp.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    @Transactional(readOnly = true) //읽기 전용
    public Iterable<Friend> findAllFriend(){
        return friendRepository.findAll();
    }

    public Friend addFriend(Friend friend){
        //Spring Data 에서는 save가 반드시 Insert만 실행되는 것은 아니다
        //ID값이 이미 존재하고 있다면 수정(Update)해주고, ID가 없다면 생성(Insert)해줌
        return friendRepository.save(friend);
    }

    public Friend findFriend(Long friendId){
        return friendRepository.findById(friendId).get();
    };
    public Friend updateFriend(Long friendId, Friend friend,String name,String email) {
        friend = friendRepository.findById(friendId).get();
        friend.setEmail(name);
        friend.setName(name);
        return friendRepository.save(friend);
    };
    public void deleteFriend(Long friendId) {
        friendRepository.delete(friendRepository.findById(friendId).get());

    }
    // ID가 존재하는지 확인하는 메소드
    public boolean existsById(long id) {
        return friendRepository.existsById(id);
    }
}
