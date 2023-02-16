# kotlin-minesweeper

---

## 현재 리팩토링 할 것

- [ ] 입력값 숫자 형식 검증
- [ ] 커스텀 예외 처리

---

## 기능 요구사항

지뢰 찾기를 변형한 프로그램을 구현한다.
- 높이와 너비, 지뢰 개수를 입력받을 수 있다. 
- 지뢰는 눈에 잘 띄는 것으로 표기한다. 
- 지뢰는 가급적 랜덤에 가깝게 배치한다. 
- 각 사각형에 표시될 숫자는 자신을 제외한 주변 8개 사각형에 포함된 지뢰의 개수다. 
- 지뢰가 없는 인접한 칸이 모두 열리게 된다.

---

## 프로그래밍 요구 사항

- 객체지향 생활 체조 원칙을 지키면서 프로그래밍한다.
- 객체지향 5원칙(SOLID)
  - SRP (단일책임의 원칙: Single Responsibility Principle): 작성된 클래스는 하나의 기능만 가지며 클래스가 제공하는 모든 서비스는 그 하나의 책임(변화의 축: axis of change)을 수행하는 데 집중되어 있어야 한다 
  - OCP (개방폐쇄의 원칙: Open Close Principle): 소프트웨어의 구성요소(컴포넌트, 클래스, 모듈, 함수)는 확장에는 열려있고, 변경에는 닫혀있어야 한다. 
  - LSP (리스코브 치환의 원칙: The Liskov Substitution Principle): 서브 타입은 언제나 기반 타입으로 교체할 수 있어야 한다. 즉, 서브 타입은 언제나 기반 타입과 호환될 수 있어야 한다. 
  - ISP (인터페이스 분리의 원칙: Interface Segregation Principle): 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다. 
  - DIP (의존성역전의 원칙: Dependency Inversion Principle): 구조적 디자인에서 발생하던 하위 레벨 모듈의 변경이 상위 레벨 모듈의 변경을 요구하는 위계관계를 끊는 의미의 역전 원칙이다.

---

## 도메인

### `RowNum` (높이)
- 행 개수 값객체
- 검증
  - NumberFormat (아직 안 함)
  - 범위 (양수)
- 너비와의 곱셈
- 행 개수만큼 Field 생성

### `ColNum` (너비)
- 열 개수 값객체
- 검증
  - NumberFormat (아직 안 함)
  - 범위 (양수)
- 높이와의 곱셈
- 인덱스를 각각 행과 열 번호로 변환
- 열 개수만큼 밭 한 줄 생성

### `MineCount` (지뢰 개수)
- 지뢰 개수 값객체
- 검증
  - NumberFormat (아직 안 함)
  - 범위 (`0` <= `count` <= `rowNum * colNum`)
- 지뢰 개수만큼 랜덤 좌표 생성

### `FieldGenerator` (정적 팩토리 객체)
- 높이
- 너비
- 지뢰 개수
- 지뢰밭 생성

### `Section` (일반) / 구현 클래스 `Safe`(안전), `Mine`(지뢰)
- `Safe`
  - mineDensity (주변 지뢰 개수)
  - 주변 지뢰 개수 + 1
- `Mine`

[//]: # (### `Row` &#40;밭 한 줄&#41;)

[//]: # (- 일급 컬렉션 &#40;`List<Section>`&#41;)

[//]: # (- 특정 인덱스&#40;`columnNum`&#41;에 지뢰 심기)

[//]: # (- 출력 포맷)

### `Field` (밭)
- 일급 컬렉션 (`List<List<Section>`)
- 특정 `Section`에 지뢰 심기
- 주변 지뢰 개수를 담은 `List<List<Int>>` 반환 (지뢰의 경우 -1 반환)

### `Coordinate`
- 행
- 열
- 지뢰 심기 메신저 (`field`에게 `rowNum`과 `columnNum` 전달)

### `Coordinates`
- 일급 컬렉션 (`List<Coordinate>`)
- 지뢰 심기 메신저 (`coordinate`에게 `field` 전달)

---

## 뷰

### `In`
- 숫자 입력
- 문자 압력

### `Out`
- 요청 출력
- 지뢰 출력

---

## 컨트롤러

### `MineSweeper`
- 높이 요청 (`Out`)
- 높이 입력 (`In`)
- 너비 요청 (`Out`)
- 너비 입력 (`In`)
- 지뢰 개수 요청 (`Out`)
- 지뢰 개수 입력 (`In`)
- 밭 생성 (`FieldGenerator`)
- 밭 출력 (`Out`)