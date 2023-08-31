# Toby의 SpringBoot

## 스프링 부트 : Containerless 개발
  - 컨테이너리스 개발이란?
  - `Dynamic Content`를 만들기 위해선 많은 `Web Component`를 Web Container에 띄워서 사용해야 함
  - `Web Component`... 즉, Servlet Container (대표적으로 `tomcat`) 를 띄우고 여러 Bean을 등록한 Spring Container를 같이 써야함
  - 하지만 `Servlet Container`는 어떤 프로젝트를 시작하더라도 공통으로 처리해줘야 하는 부분이였음  
  - 이 부분을 `spring boot`가 표준을 정해 표준에 부합한 라이브러리를 선택해주므로 개발자는 단순 반복 작업에서 벗어나게 됨
  - 


### [JDK 설치](https://sdkman.io/)
 - 참고 : https://steady-hello.tistory.com/134

#### CLI 환경에서 Spring Initializr
  1. `spring shell`
     - 스프링 쉘 시작
  2. `init --list`
      - 스프링이 제공하는 dependency list 확인
  3. `init -b {spring boot version} -d {dependency} -g {group name} -j {java version} -n {package name} -x {압축 해제}`
  4. `exit`
      - 스프링 쉘 종료
  5. `./gradlew bootRun`
      - 테스트 : `localhost:8080` 열기


#### API Test
  1. Postman
  2. [HTTPie](https://httpie.io/)
    - `spring` 실행 후 `http -v ":8080/hello?name=Spring"` 입력하면 `HelloController`의 API 결과 확인 가능