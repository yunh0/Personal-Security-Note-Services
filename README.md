# 개인 보안 노트 서비스
개인만 볼 수 있는 나만의 노트 서비스

## 요구사항
* 사용자는 본인의 노트만 저장 및 삭제하고 볼 수 있음
* 다른 사용자의 노트는 볼 수 없음
* 관리자는 관리 차원에서 사용자들의 노트 제목 리스트를 볼 수 있지만 내용을 볼 수 없음
* 관리자는 공지사항을 작성할 수 있고 일반 사용자들은 이 공지사항을 볼 수 있음

## Branch
main branch
* Spring Security 단독

JWT branch
* Spring Security + JWT

## 개발 환경

* Intellij IDEA Ultimate
* Java 17
* Spring Boot 2.5.2
* Gradle

## 기술 세부 스택

Spring Boot

* Spring Data JPA
* Spring Web
* Thymeleaf
* Spring Security
* H2 Database
* Lombok
