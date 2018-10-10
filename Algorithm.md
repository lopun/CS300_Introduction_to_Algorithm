# Lecture 1

- Asymtotic Analysis
  - Best Case / Worst Case / Average Case 를 나누는 것
  - O Notation, Sigma Notation, Theta Notation.
  - Constant(O(1)), Logarithmic(O(logn)), Linear(O(n)), n logn (O(n logn)), Quadratic(O(n^2)), Cubic(O(n^3)), Polynomial(n^(O(1)), Exponential(2^O(n))
- Optimality
  - Normal way
    - X^n = X\*X\*X\*X…
    - T(n) = n
  - Optimal Way
    - X^n = (X^(n/2))^2 <- n = even | T(n) <= T(|_n/2_|) + 1
    - X^n = (X^(n-1)/2)^2 <- n = odd | T(n) <= T(|_n/2_|) + 2
    - T(1) = 0, T(n) <= T(|_n/2_|) + 2
    - T(n) <= 2 \* log_2(n)
  - Lemma(정리)
    - Input X 를 받고 곱셈만 사용한다면 monomial(단항식)만 결과로 내놓는다.
    - L 번의 곱셈을 하면 중간의 모든 결과들은(monomial) n <= 2^L 차수를 가진다.
    - 즉, X^n 은 L >= log_2(n)이상의 곱셈을 필요로한다.
- Master Theorem
  - F(n) = a \_ F(n/b) + O(n^d)이고 n 이 b 의 배수, a, b >= 1 인 정수이고 d > 0 이면
    - a < b ^ d => F(n) is O(n^d)
    - a < b ^ d => F(n) is O(n^d \_ log(n))
    - a < b ^ d => F(n) is O(n^(log_b(a))
- Karatsuba Law / Toom’s Law
  - A(x) = a0 + a1x + a2x^2 + … + a(n-1)x^(n-1) | B(x)도 마찬가지.
  - C(x) = A(x) \* B(x), 차수 <= 2n-2
    - Normal Way(Distribute Law. 분배법칙)
      - T(n) = 4\*T(n/2) + O(n)
    - Karatsuba Law
      - T(n) = 3\*T(n/2) + O(n)
      - (A0(x) + A1(x)_x(n/2)) _ (A0(x) + A1(x)\*x(n/2)) = C0(x) + C1(x)\_x^(n/2) + C2x^n
      - C0(x) = A0(x) _ B0(x) / C2(x) = A1(x) _ B1(x)
      - C1(x) = (A0(x) + A1(x)) \_ (B0(x) + B1(x)) – C0(x) – C2(x)
    - Toom’s Law
      - (A0(x)+A1(x)·xN/3 + A2(x)·x2N/3)  (B0(x)+B1(x)·xN/3 +B2(x)·x2N/3) = C0(x) + C1(x)·xN/3 + C2(x)·x2N/3 + C3(x)·x3N/3 + C4(x)·x4N/3
      - C3 = −C0 + ⅓T1−2T2 + ⅙T3 − 3½C4
      - C2 = 3½C0 −½T1 +5T2 −½T3 + 3½C4
      - C1 = −3½C0 + ⅙T1 −2T2 +⅓T3 −C4
      - C0 = A0 · B0 ,
      - C4 = A2 · B2
      - T1 := (A0+2A1+4A2) · (B0+2B1+4B2)
      - T2 := (A0 + A1 + A2) · (B0 + B1 + B2)
      - T3 := (4A0+2A1+A2) · (4B0+2B1+B2)
      - T(n) = 5\*T(3/n)+O(n)

# Searching

- Lineary Search
  - 그냥 for 문이다.
  - T(n) = O(n)
- Binary Search
  - 이미 정렬되어있는 list 에 대해서 가능.
  - 계속 반으로 쪼개면서 왼쪽, 오른쪽, 가운데 비교.
  - T(n) = O(log n)
- Uniqueness
  - O(N^2) = e
- Quantiles(분위수)
- [Hashing](http://luyin.tistory.com/191)

# Sorting

- Specification
  - Fix set X with total order <= (오름차순이라는 말인듯?)
  - X 는 실제 값이 있는 Array / Pi 는 순서가 들어가있는 array 느낌?
  - X[n] <= X[m] comparison : cost 1
  - Swapping X[n] <-> X[m] : cost 1
  - Index integer arithmetic : cost 1
  - Pi[n] <-> Pi[m] : cost 1
- Bubble Sort
  - Pseudo code
    - For m:= N downto 2 do
      - For k:=1 to m-1 do
  - If x[k] > x[k+1] then
    - Swap(x[k], x[k+1])
  - Endif
    - Endfor
    - Endfor
  - Time complexity : O(N^2)
- Select Sort
