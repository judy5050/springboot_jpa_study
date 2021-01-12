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
     
