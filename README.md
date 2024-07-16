# 개인 보안 노트 서비스
개인만 볼 수 있는 나만의 노트 서비스

## 요구사항
* 사용자는 본인의 노트만 저장 및 삭제하고 볼 수 있음
* 다른 사용자의 노트는 볼 수 없음
* 관리자는 관리 차원에서 사용자들의 노트 제목 리스트를 볼 수 있지만 내용을 볼 수 없음
* 관리자는 공지사항을 작성할 수 있고 일반 사용자들은 이 공지사항을 볼 수 있음

## 구현 화면
* 로그인 화면
![image](https://github.com/user-attachments/assets/2b30ab0f-903a-487f-9b10-71dfb8a24d8f)
* 새 노트 작성 화면
![image](https://github.com/user-attachments/assets/289bdf86-25e0-4cf3-a1e8-9a77c50f21ff)
* 개인 노트 리스트 화면
![image](https://github.com/user-attachments/assets/b1558403-4bfe-4c34-b46d-4d7c415c518b)
* 공지사항 화면
![image](https://github.com/user-attachments/assets/c7043383-7243-443d-83ec-edaff6da7856)
* 관리자 페이지
![image](https://github.com/user-attachments/assets/da433eb8-289e-4d7d-81b5-807d058f86cd)
* 관리자 공지사항 작성화면
![image](https://github.com/user-attachments/assets/865d46d1-fac3-412a-bf91-f0850973c36a)


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
