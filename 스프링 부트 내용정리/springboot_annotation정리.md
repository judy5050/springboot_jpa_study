# 자주 사용하는 spring boot annotation 을 정리하는 공간 입니다

### @PostConstruct
     의존성 주입이 완료된 후,초기화를 수행하는 메서드이다.
     서비스 로직이 실행되기 전 발생한다.
     해당 프로젝트에서는 초기 데이터를 생성할때, 사용
### @MappedSuperclass
     추상클래스와 비슷하다.
     @entity는 실제 테이블과 매핑된다.
     하지만 @MappedSuperclass는 실제 테이블과 매핑되지 않는다
     따라서 단순히 매핑 정보를 상혹할 목적으로만 사용된다.
     (ex createDate updateDate 등 )
### @JsonInclude(JsonInclcude.Include.NON_NULL)
     json형식으로 데이터를 주고 받을 때 data 중에 NULL 필드 제외

### @JsonProperty("")
     json형식으로 변환 시 사용할 이름
     DB칼럼과 이름이 다르거나 api 응답과 이름이 다르지만 매핑해야 할때 사용
     ""안에 json 으로 변환 시 사용할 이름을 적는다.

### @JsonPropertyOrder
     해당 어노테이션을 사용해 직렬화의 특정 순서를 정할 수 있다
     
### @RestController
    srping MVC Controller 에 @ResponseBody가 추가된 것
    주 용도는 json 형태로 객체 데이터 반환
    
### @AllArgsConstructir
     클래스에 있는 존재하는 모든 필드에 대한 생성자를 자동으로 생성해준다.
     필드중 @NonNull 애노태이션 마크 존재시 자동으로 null-check로직을 자동으로 생성 해준다.
     
### @RequiredArgsConstructor 
     추가작업을 필요로 하는 필드에 대한 생성자를 생성하는 애노테이션
     초기화 되지 않은 모든 final필드, @NonNull로 마크되어 있는 모든 필드에 대해 생성자를 자동으로
     생성해준다.
     @NonNull마크가 있을경우 자동으로 null-check로직이 생성된다. 
     @NonNull 마크가 있지만, 파라미터에서 null이 들어올경우 NullPointerException 이 발생한다.

### @Builder
     Class(Type)가 Target일 경우에 생성자 유무에 따라 다르게 동작
     생성자가 없는 경우 :모든 멤버변수를 파라미터로 받는 기본 생성자 생성
     생성자가 있을 경우 :따로 생성자 생성 X
