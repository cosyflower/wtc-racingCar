## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)
---
> Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
---
기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)

- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

---
### Basic Concept
- Input 그리고 Output 에 신경쓰는 TDD 작성하기
- 흐름에 맞게 작성하고, Naming에 유의하기
- Basic Skeleton을 형성하는 과정에서 네이밍을 진행하고, 각각의 기능을 담당한 클래스 별로 구분하는 연습해보기
- TDD 기법을 적용하면서 진행하기 

### To-Do List 작성하기
> 실패하는 테스트 만들기 - 성공할 정도로의 테스트 만들기 - 리팩토링의 과정을 반복할 것 

가장 쉬운 테스트를 작성해보기 ( 쉼표 그리고 콜론을 Delimiter로 분리한 후 합 구하기 )
- 입력한 문자열을 검증합니다 ( validateInput() - inputValidator)
  - [] 숫자, 쉼표, 콜론을 포함한 문자열인지 확인합니다 hasCorrectInput() 
  - [] **예외 처리** isEmpty() 한 문자열, 빈 문자열인 경우에은 0을 반환합니다 - isBlankInput() 
  - [] **예외 처리** 수로만 구성된 문자열의 경우 구성된 문자열을 정수로 변환한 결과를 반환합니다 - isOnlyNumber()
  - [] **예외 처리** 숫자, 쉼표, 콜론 이외의 문자가 포함된 경우 RunTimeException을 throw 합니다 - hasWrongInput()
  - [] **예외 처리** null이 입력된 경우 RunTimeException을 throw 합니다 - isNull()

- 검증된 문자열에서 쉼표 혹은 콜론을 구분자로 나눕니다
  - [] 쉼표를 구분자로 나누는 기능 ( splitByComma() )
  - [] 콜론은 구분자로 나누는 기능 ( splitByColon() )
  - [] 쉼표와 콜론을 모두 구분자로 나누는 기능 ( splitByCommaAndColon() )
