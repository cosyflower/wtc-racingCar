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
  - [x] 숫자, 쉼표, 콜론을 포함한 문자열인지 확인합니다 hasCorrectInput() 
  - [x] **출력 처리** isEmpty() 한 문자열, 빈 문자열인 경우에은 0을 반환합니다 - isBlankInput() 
  - [x] **출력 처리** 수로만 구성된 문자열의 경우 구성된 문자열을 정수로 변환한 결과를 반환합니다 - isOnlyNumber()
  - [x] **예외 처리** 숫자, 쉼표, 콜론 이외의 문자가 포함된 경우 RunTimeException을 throw 합니다 - hasWrongInput()
    - [x] 숫자 중 음수가 포함된 경우 RunTimeException을 throw 합니다 
  - [x] **예외 처리** null이 입력된 경우 RunTimeException을 throw 합니다 - isNull()

- 검증된 문자열에서 쉼표 혹은 콜론을 구분자로 나눕니다
  - [x] 쉼표를 구분자 혹은 콜론으로 나누는 기능 ( splitToTokens() - InputString )

- 커스텀 문자열을 검증합니다 (validateCustomInput() - customValidator)
  - [x] : '//', '\n' 사이에 문자가 존재하는지 확인합니다 - hasDelimiter() - customValidator
  - [x] : 커스텀 구분자를 검츨합니다 - findDelimiter() - CustomInput or customValidator
  - [x] : 커스텀 구분자가 포함된 문자열인지 확인합니다 - hasCorrectInput() - customValidator
    - [x] : **예외** 커스텀 구분자가 마지막에 위치한 경우, IllegalArgumentException을 throw 합니다 - isDelimiterLast() - custom.. 
    - [x] : **예외** 커스텀 구분자, 숫자 외 다른 문자가 포함된 경우, IllegalArgumentException을 throw 합니다 - hasWrongInput() - custom..
    - [x] : **예외** 커스텀 구분자 없이 숫자만 존재하는 경우, 해당 수를 결과로 출력합니다 - hasOnlyNumbers() - custom..

---
### To-Do List 작성하기 - RacingCar 
> 실패하는 테스트 만들기 - 성공할 정도로의 테스트 만들기 - 리팩토링의 과정을 반복할 것 

*TOTAL 22M*

각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 **초과**할 수 없다. // (1) - 자동차 이름 입력 받는 것부터 TDD
- [] 이름을 쉽표로 구분하여 입력합니다 : Car, NameValidator 
  - [x] **예외** | 쉽표로 구분하지 않고 입력한 경우 : hasNoCommas()
  - [x] **예외** | 5자를 초과하여 입력한 경우 : LongerThanFive()
  - [x] **예외** | 이름이 중복된 경우 : duplicatedName()
    - [] **예외 처리 ** | 에러 발생 메세지를 출력하고, 재입력을 받습니다

전진하는 자동차 출력시 이름도 같이 출력합니다 - OutputView
- [] 전진하는 자동차를 출력합니다 - OutputView, Cars 

- 전진하는 조건 0-9 Random 값에서 4 이상의 값이 등장하는 경우입니다 - RandomGenerator, RandomGenerator.generate() 
- [] 4이상의 경우 자동차를 전진합니다 - Car, moveForward(int random)
- [] 4보다 작은 경우 자동차를 전진하지 않습니다 

- **자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.** - OutputView, showWinner()
  - [] 가장 많이 전진한 자동차 이름을 파악합니다 : Cars, car, findMaxPosition
  - [] 우승한 자동차를 출력합니다 
