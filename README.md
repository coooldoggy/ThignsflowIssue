# ThignsflowIssue

1. 상단에 Organization Name / Repository Name이 표시됩니다.
2. 상단의 제목 (google/dagger) 을 클릭하면 팝업 입력창이 떠서 다른 Repository 를 입력 받을 수 있도록 하 며, 입력된 Repository 의 이슈 내용을 보여주세요. 만약 입력한 Repository 를 조회할 수 없는 경우 팝업으 로 오류를 보여주고, 이전 Repository 로 돌아갑니다.
3. 아래 Github API를 이용해서 해당하는 Repository 의 이슈 목록을 “#이슈번호 : 이슈제목” 형태의 텍스트 목록으로 화면에 출력해주세요.
•https://api.github.com/repos/{org}/{repo}/issues  •위 결과의 number와 title을 사용하시면 됩니다.
4. Github API 를 이용한 데이터 조회 시 앱의 액티비티가 아닌, 안드로이드 서비스를 이용하여 매 5분마다 주 기적으로 최신 데이터를 조회하도록 구현해주세요.
5. 다섯번째 아이템에는 아래 주소의 이미지 배너를 출력해주세요. •https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png
6. 텍스트 요소를 클릭할 경우 해당 이슈의 상세 화면 (예시 두번째 화면) 이 열리도록 해주세요. •상세 화면의 상단 바에는 해당 이슈의 이슈번호가 출력되어야 합니다. (#0000)
7. 이미지 배너 요소를 클릭할 경우 웹 페이지 (예시 세번째 화면) 이 열리도록 해주세요.
•웹 페이지 주소: https://thingsflow.com/ko/home
8. 앱을 실행하면 마지막에 성공적으로 조회했던 Repository 를 보여주세요.
9. 조회한 데이터는 SQLite 를 이용하여 저장하고 화면에는 SQLite 데이터베이스를 조회하여 보여주는 방식으 로 구현해주세요. (Room 을 이용하셔도 됩니다.)
     
10. 한 번이라도 데이터를 조회한 Repository 의 경우 인터넷이 안 되는 상황에서도 마지막으로 조회한 이슈 내 용을 확인할 수 있어야 합니다.
11. 위 조건에 명시되지 않은 Component, Library, Architecture pattern 등 기술적인 사항에 대한 제한사항은 없으므로, 편하신 방법으로 자유롭게 개발해주세요.
12. 제한 시간은 6시간입니다.
