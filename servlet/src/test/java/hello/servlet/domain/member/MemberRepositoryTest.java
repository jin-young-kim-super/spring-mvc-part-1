package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {

        //given
        Member member = new Member("kim", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertThat(member).isEqualTo(savedMember);
    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("kim1", 20);
        Member member2 = new Member("kim2", 21);

        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        //when
        List<Member> allMember = memberRepository.findAll();

        //then
        assertThat(allMember.size()).isEqualTo(2);
        assertThat(allMember).contains(member1,member2);
    }
}