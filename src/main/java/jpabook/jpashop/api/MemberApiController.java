package jpabook.jpashop.api;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {


    private final MemberService memberService;

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


}
