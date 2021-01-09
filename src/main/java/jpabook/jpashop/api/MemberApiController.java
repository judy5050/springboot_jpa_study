package jpabook.jpashop.api;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {


    private final MemberService memberService;

    @GetMapping("/api/v1/members")//v1에서 회원 엔티티를 그대로 가져올 경우, 회원 정보만 호죄하고 싶은데 회원 엔티티에 있는 모든 정보들이 노출된다.
    public List<Member> membersV1(){
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result memberV2(){
        List<Member> findMembers=memberService.findMembers();
        List<MemberDto> collect=findMembers.stream()
                .map(m->new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(),collect);

    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static  class MemberDto{
        private String name;
    }


    @PostMapping("/api/v1/members")//v1의 api는 entity와 api가 일대 일 매핑인것이 문제, entity를 변경하면 api스펙 또한 같이 변경된다.
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member)//따로 class만들 필요 x
    {
        Long id=memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")//api 스펙이 변동 x,오류로 알려줌 파라미터와 컨트롤러가 매핑조절, 별도의 api 용 dto 만듦//엔티티 외부 노출 x
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){

        Member member=new Member();
        member.setName(request.getName());

        Long id=memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static  class CreateMemberRequest{

        private String name;
    }

    @Data
    static class CreateMemberResponse{
        private Long id;

        public CreateMemberResponse(Long id){

            this.id=id;
        }

    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse saveMemberV2(@PathVariable("id") Long id,@RequestBody @Valid UpdateMemberRequest request){

        memberService.update(id,request.getName());//변경 감지
        Member findMember=memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(),findMember.getName());

    }
    @Data
    static class UpdateMemberRequest{
        private String name;
    }
    @Data
    @AllArgsConstructor //해당어노테이션 알아보기
    static class UpdateMemberResponse{

        private Long id;
        private String name;
    }






}
