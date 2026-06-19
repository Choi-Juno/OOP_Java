# 🎨 객체지향 프로그래밍 기말 GUI 실습 종합 대비집 (Java Swing)

> **목적**: 시험장에서 "완전히 동작하는 스윙 프로그램"을 빠르게 만들기 위한 복붙용 템플릿 + 난이도별 예상문제 + 모범답안 + 채점 기준 통합본
> **범위**: 9장(스윙·배치관리자) · 10장(이벤트) · 11장(컴포넌트) · 12장(그래픽) + 수업용 **GUI 좀비 게임**
> **사용법**: PART 1로 골격 암기 → PART 2 완성 템플릿 통째 복붙 연습 → PART 3 예상문제를 40분 내 풀기 → PART 4 채점표로 자가 점검
> **핵심 통찰**: 중간고사의 *콘솔* 좀비게임이 기말엔 **GUI(스윙) 좀비게임**으로 진화해 「클래스 정의 → 게임 기능 추가 → 점수/저장」 형식으로 나올 확률이 가장 높습니다.

---

## 📑 목차

### PART 1 — 복붙용 치트시트
1. [import 모음](#1-import-모음)
2. [스윙 프레임 뼈대](#2-스윙-프레임-뼈대)
3. [컨텐트팬 & 배치관리자](#3-컨텐트팬--배치관리자)
4. [절대배치 (게임용)](#4-절대배치-게임용)
5. [컴포넌트 빠른 생성](#5-컴포넌트-빠른-생성)
6. [이벤트 리스너 3종](#6-이벤트-리스너-3종)
7. [ActionListener (버튼·텍스트필드·콤보)](#7-actionlistener)
8. [MouseListener / MouseAdapter](#8-mouselistener--mouseadapter)
9. [KeyListener / KeyAdapter + 포커스](#9-keylistener--keyadapter--포커스)
10. [ItemListener (체크·라디오)](#10-itemlistener)
11. [paintComponent & Graphics](#11-paintcomponent--graphics)
12. [Color & Font](#12-color--font)
13. [이미지 그리기 (drawImage)](#13-이미지-그리기-drawimage)
14. [repaint / revalidate / 클리핑](#14-repaint--revalidate--클리핑)
15. [게임 루프 (Thread + Runnable)](#15-게임-루프-thread--runnable)
16. [충돌 판정 패턴](#16-충돌-판정-패턴)
17. [Vector & 파일 입출력](#17-vector--파일-입출력)

### PART 2 — 완성 프로그램 템플릿
18. [🎯 GUI 좀비게임 (이미지 없이 도형으로, 즉시 실행)](#18--gui-좀비게임-완성-템플릿)
19. [🎯 마우스 그림판](#19--마우스-그림판-완성-템플릿)
20. [🎯 입력 폼 + 처리 (계산기)](#20--입력-폼--처리-완성-템플릿)

### PART 3 — 난이도별 예상문제집
- [문제 1. 신호등 만들기 ⭐⭐](#문제-1-신호등-만들기-)
- [문제 2. 마우스 클릭 도형 그리기 ⭐⭐⭐](#문제-2-마우스-클릭-도형-그리기-)
- [문제 3. 키보드로 우주선 움직이기 ⭐⭐⭐](#문제-3-키보드로-우주선-움직이기-)
- [문제 4. 체크박스 과일 가격 합산 ⭐⭐⭐](#문제-4-체크박스-과일-가격-합산-)
- [문제 5. 슬라이더로 원 색·크기 제어 ⭐⭐⭐⭐](#문제-5-슬라이더로-원-색크기-제어-)
- [문제 6. GUI 좀비게임 + 보물 시스템 (종합판) ⭐⭐⭐⭐⭐](#문제-6-gui-좀비게임--보물-시스템-종합판-)

### PART 4 — 시험장 도구
- [⚡ 채점 기준 체크리스트](#-채점-기준-체크리스트)
- [🧩 문제 유형 빠른 판단 가이드](#-문제-유형-빠른-판단-가이드)
- [⚠️ 실수 방지 체크리스트](#️-실수-방지-체크리스트)
- [📦 import 치트시트 (복붙용)](#-import-치트시트-복붙용)
- [🔑 개념 단답 비교표](#-개념-단답-비교표)

---

# PART 1 — 복붙용 치트시트

## 1. import 모음

```java
import javax.swing.*;        // JFrame, JButton, JLabel ... 모든 스윙 컴포넌트
import java.awt.*;           // Container, Graphics, Color, Font, FlowLayout ...
import java.awt.event.*;     // ActionListener, MouseListener, KeyListener ...
import javax.swing.event.*;  // ChangeListener (JSlider용)
import java.util.*;          // Vector, Random
import java.io.*;            // 파일 입출력
```

---

## 2. 스윙 프레임 뼈대

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("제목");                                 // ① 타이틀
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // ② X → 프로그램 종료
        Container c = getContentPane();                   // ③ 컨텐트팬
        c.setLayout(new FlowLayout());                    // ④ 배치관리자
        // ⑤ c.add(...) 로 컴포넌트 추가
        setSize(300, 200);                                // ⑥ 크기
        setVisible(true);                                 // ⑦ 출력 (항상 마지막)
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
```

> **순서 규칙**: 컴포넌트 add → `setSize` → `setVisible(true)`. 포커스를 줄 땐 `setVisible(true)` *다음에* `requestFocus()`.

---

## 3. 컨텐트팬 & 배치관리자

```java
Container c = getContentPane();   // 컨텐트팬 얻기
// setContentPane(panel);         // 패널로 통째 교체 (그래픽 패널 쓸 때)
```

| 배치관리자 | 방식 | 생성자 |
|-----------|------|--------|
| **FlowLayout** | 왼→오 흐름 배치 | `new FlowLayout(FlowLayout.LEFT, 30, 40)` |
| **BorderLayout** | 동서남북중앙 5분할 | `new BorderLayout(30, 20)` |
| **GridLayout** | 행×열 격자 | `new GridLayout(4, 2, 5, 5)` |
| **null** | 절대 위치/크기 | `c.setLayout(null);` |

```java
// FlowLayout
c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
c.add(new JButton("add"));

// BorderLayout (구역 지정 필수)
c.setLayout(new BorderLayout());
c.add(new JButton("중앙"), BorderLayout.CENTER);
c.add(new JButton("위"),   BorderLayout.NORTH);
c.add(new JButton("아래"), BorderLayout.SOUTH);
c.add(new JButton("동"),   BorderLayout.EAST);
c.add(new JButton("서"),   BorderLayout.WEST);

// GridLayout (입력 폼)
c.setLayout(new GridLayout(4, 2, 5, 5));
c.add(new JLabel(" 이름")); c.add(new JTextField());
```

---

## 4. 절대배치 (게임용)

> 컴포넌트를 자유 위치로 움직이려면 배치관리자를 제거합니다. (게임 단골)

```java
c.setLayout(null);                       // 배치관리자 제거
JLabel la = new JLabel("HELLO");
la.setBounds(50, 50, 100, 20);           // (x, y, w, h) 한 번에
// la.setLocation(50, 50);  la.setSize(100, 20);  // 따로따로도 가능
c.add(la);
```

| 메소드 | 기능 |
|--------|------|
| `setLocation(x, y)` | 위치 |
| `setSize(w, h)` | 크기 |
| `setBounds(x, y, w, h)` | 위치+크기 동시 |

---

## 5. 컴포넌트 빠른 생성

```java
// JLabel — 문자열/이미지 표시
JLabel la = new JLabel("텍스트");
JLabel img = new JLabel(new ImageIcon("images/a.jpg"));
JLabel both = new JLabel("텍스트", new ImageIcon("a.jpg"), SwingConstants.CENTER);

// JButton — Action 이벤트
JButton btn = new JButton("확인");

// JCheckBox — Item 이벤트 (다중 선택)
JCheckBox cb = new JCheckBox("사과", true);   // 두번째 인자 = 초기 선택

// JRadioButton — Item 이벤트 (그룹 중 1개)  ★ ButtonGroup 필수
ButtonGroup g = new ButtonGroup();
JRadioButton r1 = new JRadioButton("남"); JRadioButton r2 = new JRadioButton("여");
g.add(r1); g.add(r2);                     // 그룹에 묶어야 배타 선택
c.add(r1); c.add(r2);                     // 컨테이너에도 add

// JTextField — Action(<Enter>) 이벤트
JTextField tf = new JTextField(20);       // 20칸
String txt = tf.getText();  tf.setText("");  tf.setEditable(false);

// JTextArea — 여러 줄 (스크롤은 JScrollPane)
JTextArea ta = new JTextArea(7, 20);
c.add(new JScrollPane(ta));               // 스크롤바
ta.append("줄 추가\n");

// JComboBox — Action 이벤트
JComboBox<String> combo = new JComboBox<>(new String[]{"apple","banana"});
combo.addItem("kiwi");
int idx = combo.getSelectedIndex();

// JSlider — Change 이벤트
JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100); // (방향, 최소, 최대, 초기)
slider.setPaintTicks(true); slider.setPaintLabels(true);
slider.setMajorTickSpacing(50);
```

### JComponent 공통 메소드 (모든 컴포넌트)
```java
comp.setBackground(Color.YELLOW);   // 배경 (보이려면 setOpaque(true))
comp.setForeground(Color.RED);      // 글자색
comp.setFont(new Font("Arial", Font.ITALIC, 20));
comp.setEnabled(false);             // 비활성화
comp.setOpaque(true);               // 배경 보이게
```

---

## 6. 이벤트 리스너 3종

```java
// ① 독립 클래스 (여러 곳 재사용)
class MyListener implements ActionListener {
    public void actionPerformed(ActionEvent e) { ... }
}
btn.addActionListener(new MyListener());

// ② 내부 클래스 (외부 클래스 멤버 접근 용이)
private class MyListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        OuterClass.this.setTitle("...");   // 바깥 멤버 접근
    }
}

// ③ 익명 클래스 (가장 간결, 실전 1순위)
btn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) { ... }
});
```

---

## 7. ActionListener

> 발생: **버튼 클릭 / 텍스트필드 `<Enter>` / 콤보박스 선택 / 메뉴 선택**

```java
// 버튼
btn.addActionListener(e -> System.out.println("클릭됨"));   // 람다도 가능

// e.getSource()는 항상 캐스팅
btn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        b.setText("바뀜");
    }
});

// 텍스트필드: 입력 → 처리 → 비우기
tf.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        ta.append(tf.getText() + "\n");
        tf.setText("");
    }
});

// 콤보박스: 선택 인덱스로 분기
combo.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int index = combo.getSelectedIndex();
        imgLabel.setIcon(images[index]);
    }
});
```

---

## 8. MouseListener / MouseAdapter

**MouseListener (5개)** + **MouseMotionListener (2개)**
```java
mousePressed(e)   mouseReleased(e)   mouseClicked(e)   mouseEntered(e)   mouseExited(e)
mouseDragged(e)   mouseMoved(e)
```
**호출 순서**: 누르고 떼면 `Pressed → Released → Clicked`. 드래그는 `Pressed → Dragged*… → Released`.

```java
// ★ MouseAdapter로 필요한 것만 구현 (권장)
c.addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        int x = e.getX();              // 좌표
        int y = e.getY();
        if (e.getClickCount() == 2) { ... }            // 더블클릭
        if (e.getButton() == MouseEvent.BUTTON1) { ... } // 왼쪽
        la.setLocation(x, y);
    }
});

// 드래그까지 처리하려면 MotionListener도 등록
c.addMouseMotionListener(new MouseAdapter() {
    public void mouseDragged(MouseEvent e) { ... }
});
```

| 메소드 | 반환 |
|--------|------|
| `getX()`, `getY()`, `getPoint()` | 좌표 |
| `getClickCount()` | 클릭 수 (2=더블) |
| `getButton()` | `MouseEvent.BUTTON1`(왼쪽) 등 |

---

## 9. KeyListener / KeyAdapter + 포커스

> 키 이벤트를 받으려면 **포커스**가 필요합니다 (자주 빠뜨림).

```java
setVisible(true);          // 먼저 출력
panel.setFocusable(true);  // 포커스 받을 수 있게
panel.requestFocus();      // 포커스 강제 지정
```

**3개 메소드**: `keyPressed`(모든 키) / `keyReleased`(모든 키) / `keyTyped`(문자 키만)

```java
panel.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:    y -= 10; break;
            case KeyEvent.VK_DOWN:  y += 10; break;
            case KeyEvent.VK_LEFT:  x -= 10; break;
            case KeyEvent.VK_RIGHT: x += 10; break;
            case KeyEvent.VK_SPACE: /* 점프/발사 */ break;
        }
        // 문자 키 판별은 getKeyChar()
        if (e.getKeyChar() == '%') { ... }
        repaint();
    }
});
```

| 메소드 | 용도 |
|--------|------|
| `getKeyCode()` | 모든 키 (제어키 포함). `KeyEvent.VK_XXX`와 비교 |
| `getKeyChar()` | 문자 키 (`'a'`, `'%'`) |
| `getKeyText(code)` | 키 이름 문자열 ("F1") |

---

## 10. ItemListener

> 발생: **체크박스 / 라디오버튼** 선택 상태 변경

```java
cb.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {     // 선택됨
            if (e.getItem() == apple) sum += 100;
        } else {                                            // 해제됨(DESELECTED)
            if (e.getItem() == apple) sum -= 100;
        }
    }
});
```

---

## 11. paintComponent & Graphics

```java
class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // ★ 필수 (배경 초기화·잔상 제거)
        g.setColor(Color.RED);
        g.drawRect(10, 10, 50, 50);  // 여기에 그리기
    }
}
```

| 그리기(외곽) | 칠하기(내부) | 인자 |
|--------------|--------------|------|
| `drawLine(x1,y1,x2,y2)` | — | 두 점 |
| `drawRect(x,y,w,h)` | `fillRect(...)` | 위치+크기 |
| `drawOval(x,y,w,h)` | `fillOval(...)` | 타원/원 |
| `drawRoundRect(x,y,w,h,aw,ah)` | `fillRoundRect(...)` | 둥근사각 |
| `drawArc(x,y,w,h,start,arc)` | `fillArc(...)` | 호(각도°) |
| `drawPolygon(int[] x, int[] y, n)` | `fillPolygon(...)` | 다각형 |
| `drawString(str,x,y)` | — | 문자열 |

> **규칙**: 칠하기는 `draw`→`fill`만 바꾸면 인자 동일. `paintComponent`는 직접 호출 금지 → `repaint()` 사용.

---

## 12. Color & Font

```java
g.setColor(Color.RED);                  // 상수
g.setColor(new Color(255, 0, 0));       // RGB (0~255)
g.setColor(new Color(0x0000ff00));      // 0x00rrggbb
g.setFont(new Font("Arial", Font.BOLD, 20));  // (글꼴, 스타일, 크기)
// 스타일: Font.PLAIN / Font.BOLD / Font.ITALIC
```

---

## 13. 이미지 그리기 (drawImage)

```java
ImageIcon icon = new ImageIcon("images/hero.png");
Image img = icon.getImage();

g.drawImage(img, x, y, this);                       // 원본 크기
g.drawImage(img, x, y, w, h, this);                 // 크기 조절
g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // 패널 꽉 채움(가변)
g.drawImage(img, 20,20,250,100, 50,0,150,150, this);   // 일부분 잘라 그리기
```
> 마지막 인자 ImageObserver는 보통 `this` 또는 `null`.

---

## 14. repaint / revalidate / 클리핑

```java
component.repaint();                 // 모양/위치 바꾼 뒤 다시 그리기
component.getParent().repaint();     // 위치 변경 시 잔상 방지(부모부터)
container.revalidate();              // 컴포넌트 삽입/삭제 후 재배치
g.setClip(100, 20, 150, 150);        // 클리핑 영역 설정 (이 영역만 그려짐)
```

---

## 15. 게임 루프 (Thread + Runnable)

```java
class GamePanel extends JPanel implements Runnable {
    public GamePanel() {
        new Thread(this).start();        // 스레드 시작
    }
    public void run() {
        while (true) {
            // ① 상태 갱신(이동·충돌)  ② 다시 그리기
            repaint();
            try { Thread.sleep(200); } catch (InterruptedException e) { break; }
        }
    }
}
```
> `Thread.sleep`은 반드시 try-catch(InterruptedException). 스레드는 `run()`이 아니라 `start()`로 시작.

---

## 16. 충돌 판정 패턴

```java
// 두 점 사이 거리 < 임계값 → 충돌
public boolean crush(int ox, int oy) {
    double d = Math.sqrt(Math.pow(this.x - ox, 2) + Math.pow(this.y - oy, 2));
    return d < 20;
}

// 사각형 겹침 판정(대안)
boolean hit = (Math.abs(x - ox) < 20 && Math.abs(y - oy) < 20);
```

---

## 17. Vector & 파일 입출력

```java
import java.util.*;
Vector<String> gems = new Vector<>();
gems.add("금");  gems.get(0);  gems.size();
for (String s : gems) System.out.println(s);

// 텍스트 저장
try (BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"))) {
    for (String s : gems) bw.write(s + "\n");
} catch (IOException e) { e.printStackTrace(); }

// 텍스트 로드
try (BufferedReader br = new BufferedReader(new FileReader("save.txt"))) {
    String line;
    while ((line = br.readLine()) != null) gems.add(line);
} catch (IOException e) { e.printStackTrace(); }

// 객체 통째 저장(직렬화) — 클래스에 implements Serializable, 이미지 필드엔 transient
try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"))) {
    out.writeObject(gems);
} catch (IOException e) { e.printStackTrace(); }
```

---

# PART 2 — 완성 프로그램 템플릿

> 아래 템플릿들은 **이미지 파일 없이 도형만으로** 즉시 컴파일·실행됩니다. (시험장에 이미지 에셋이 없을 수 있으므로 가장 안전한 형태) 이미지가 필요하면 `g.fillRect/fillOval` 부분을 `g.drawImage(img, ...)`로 교체하면 됩니다.

## 18. 🎯 GUI 좀비게임 완성 템플릿

> **포함 개념**: JFrame · JPanel · KeyListener · Thread(Runnable) · paintComponent · 충돌 판정 · Vector · 파일 I/O · 점수 표시
> **게임 규칙**: 화살표로 영웅(파랑) 이동, ↑ 점프. 좀비(초록)에 닿으면 사망. 보물(노랑/흰/회색)을 먹으면 Vector에 저장·점수 증가. 오른쪽 끝 도달 시 승리. `S`=저장, `L`=불러오기.

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

// ===== 1) 영웅 =====
class Hero {
    int x, y;
    final int SIZE = 20, STEP = 7, MAX_X = 480;
    boolean isJump = false;
    int jumpCount = 0;
    Hero(int x, int y) { this.x = x; this.y = y; }
    void moveLeft()  { x -= STEP; if (x < 0) x = 0; }
    void moveRight() { x += STEP; if (x > MAX_X) x = MAX_X; }
    void update() {                       // 점프 물리(올라갔다 내려옴)
        if (isJump) {
            if (jumpCount < 5) y -= 12;
            else if (jumpCount < 10) y += 12;
            jumpCount++;
            if (jumpCount >= 10) { jumpCount = 0; isJump = false; }
        }
    }
    void draw(Graphics g) { g.setColor(Color.CYAN); g.fillRect(x, y, SIZE, SIZE); }
    boolean reachGoal() { return x >= MAX_X; }
}

// ===== 2) 좀비 =====
class Zombie {
    int x, y;
    final int SIZE = 20, STEP = 7, MAX_X = 480;
    Random rand = new Random();
    Zombie(int x, int y) { this.x = x; this.y = y; }
    void randomMove() {
        int dir = rand.nextInt(3);        // 0:정지 1:왼쪽 2:오른쪽
        if (dir == 1) { x -= STEP; if (x < 0) x = 0; }
        else if (dir == 2) { x += STEP; if (x > MAX_X) x = MAX_X; }
    }
    void draw(Graphics g) { g.setColor(Color.GREEN); g.fillRect(x, y, SIZE, SIZE); }
    boolean crush(int ox, int oy) {
        return Math.sqrt(Math.pow(x-ox,2)+Math.pow(y-oy,2)) < 20;
    }
}

// ===== 3) 보물 (클래스 정의 문제 대비) =====
class Gem {
    String name;   // "다이아","금","은"
    int number;    // 1,2,3
    int x, y;
    final int SIZE = 16;
    Gem(String name, int number, int x, int y) {
        this.name = name; this.number = number; this.x = x; this.y = y;
    }
    void draw(Graphics g) {
        if (number == 1) g.setColor(Color.WHITE);
        else if (number == 2) g.setColor(Color.YELLOW);
        else g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x, y, SIZE, SIZE);
    }
    boolean crush(int ox, int oy) {
        return Math.sqrt(Math.pow(x-ox,2)+Math.pow(y-oy,2)) < 20;
    }
    void getItem() { System.out.println(name + " 을 획득했습니다."); }
}

// ===== 4) 게임 패널 =====
class GamePanel extends JPanel implements KeyListener, Runnable {
    Hero hero = new Hero(0, 171);
    Zombie zombie1 = new Zombie(150, 171);
    Zombie zombie2 = new Zombie(350, 171);
    Gem gem;
    Vector<String> myGems = new Vector<>();
    String[] names = {"다이아", "금", "은"};
    Random rand = new Random();
    boolean gameOver = false, dead = false;

    GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        makeGem();
        new Thread(this).start();
    }

    void makeGem() {                         // 랜덤 종류·랜덤 위치 생성
        int idx = rand.nextInt(3);
        int gx = rand.nextInt(480);
        gem = new Gem(names[idx], idx + 1, gx, 171);
        System.out.println(gx + "위치에 " + names[idx] + "가 있습니다.");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);  g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.ORANGE); g.fillRect(0, 200, getWidth(), getHeight());
        if (gem != null) gem.draw(g);
        zombie1.draw(g); zombie2.draw(g); hero.draw(g);
        g.setColor(Color.WHITE);
        g.drawString("획득 보물: " + myGems.size() + "개   (S:저장  L:불러오기)", 10, 20);
        if (gameOver) g.drawString("목적지 도착! 보물 " + myGems.size() + "개 획득", 160, 100);
        if (dead) { g.setColor(Color.RED); g.drawString("좀비에게 잡혔습니다.", 180, 130); }
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT)  hero.moveLeft();
        else if (code == KeyEvent.VK_RIGHT) hero.moveRight();
        else if (code == KeyEvent.VK_UP)    hero.isJump = true;
        else if (code == KeyEvent.VK_S)     save();
        else if (code == KeyEvent.VK_L)     load();
        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void run() {                       // 게임 루프
        while (!gameOver && !dead) {
            zombie1.randomMove();
            zombie2.randomMove();
            hero.update();
            if (gem != null && gem.crush(hero.x, hero.y)) {   // 보물 획득
                myGems.add(gem.name);
                System.out.println(gem.name + "를 획득하였습니다.");
                makeGem();
            }
            if (zombie1.crush(hero.x, hero.y) || zombie2.crush(hero.x, hero.y)) dead = true;
            if (hero.reachGoal()) gameOver = true;
            repaint();
            try { Thread.sleep(200); } catch (InterruptedException e) { break; }
        }
        repaint();
    }

    void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("zombie.sav"))) {
            for (String s : myGems) bw.write(s + "\n");
            System.out.println("저장 완료: " + myGems.size() + "개");
        } catch (IOException ex) { ex.printStackTrace(); }
    }
    void load() {
        myGems.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("zombie.sav"))) {
            String line;
            while ((line = br.readLine()) != null) myGems.add(line);
            System.out.println("불러오기 완료: " + myGems.size() + "개");
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}

// ===== 5) 메인 프레임 =====
public class ZombieGame extends JFrame {
    public ZombieGame() {
        setTitle("좀비 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel());
        setSize(500, 300);
        setVisible(true);
    }
    public static void main(String[] args) { new ZombieGame(); }
}
```

---

## 19. 🎯 마우스 그림판 완성 템플릿

> **포함 개념**: MouseListener(드래그) · Vector · paintComponent · JButton(지우기)

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PaintBoard extends JFrame {
    public PaintBoard() {
        setTitle("그림판");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        JButton clear = new JButton("지우기");
        clear.addActionListener(e -> panel.clear());
        add(panel, BorderLayout.CENTER);
        add(clear, BorderLayout.SOUTH);
        setSize(500, 400);
        setVisible(true);
    }
    class DrawPanel extends JPanel {
        Vector<Point> points = new Vector<>();   // 지나간 점들 저장
        DrawPanel() {
            // 드래그하면 점을 계속 추가
            addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
            });
        }
        public void clear() { points.clear(); repaint(); }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            for (Point p : points) g.fillOval(p.x, p.y, 8, 8);
        }
    }
    public static void main(String[] args) { new PaintBoard(); }
}
```

---

## 20. 🎯 입력 폼 + 처리 완성 템플릿

> **포함 개념**: GridLayout/FlowLayout · JTextField · JButton · ActionListener · JLabel 결과 표시 (계산기)

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField t1 = new JTextField(5);
    private JTextField t2 = new JTextField(5);
    private JLabel result = new JLabel("결과 = ?");

    public Calculator() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(t1);
        c.add(t2);
        String[] ops = {"+", "-", "*", "/"};
        for (String op : ops) {
            JButton b = new JButton(op);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int a = Integer.parseInt(t1.getText());
                        int b = Integer.parseInt(t2.getText());
                        String o = ((JButton)e.getSource()).getText();
                        int r = 0;
                        switch (o) {
                            case "+": r = a + b; break;
                            case "-": r = a - b; break;
                            case "*": r = a * b; break;
                            case "/": r = a / b; break;
                        }
                        result.setText("결과 = " + r);
                    } catch (NumberFormatException ex) {
                        result.setText("숫자를 입력하세요");
                    }
                }
            });
            c.add(b);
        }
        c.add(result);
        setSize(320, 150);
        setVisible(true);
    }
    public static void main(String[] args) { new Calculator(); }
}
```

---

# PART 3 — 난이도별 예상문제집

> **사용법**: 문제만 보고 40분 내 작성 → 모범답안과 비교 → 요구사항별 구현 패턴 체크.

---

## 문제 1. 신호등 만들기 ⭐⭐

### 📋 요구사항
버튼을 누를 때마다 신호등 색이 **빨강 → 초록 → 노랑 → 빨강…** 순환하는 프로그램을 만드시오.
- [ ] 패널에 원 3개(빨/노/초)를 세로로 그리되, 현재 색만 진하게(나머지는 어둡게)
- [ ] 아래에 "변경" 버튼, 클릭 시 색 변경 후 `repaint()`
- [ ] BorderLayout 사용 (CENTER=패널, SOUTH=버튼)

### 💡 출제 의도
JFrame 골격 · BorderLayout · JButton + ActionListener · paintComponent(fillOval) · repaint 연동.

### ✅ 모범답안
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLight extends JFrame {
    private int state = 0;   // 0:빨강 1:초록 2:노랑
    private LightPanel panel = new LightPanel();

    public TrafficLight() {
        setTitle("신호등");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn = new JButton("변경");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                state = (state + 1) % 3;   // 0→1→2→0 순환
                panel.repaint();
            }
        });
        add(panel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        setSize(200, 400);
        setVisible(true);
    }
    class LightPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 빨강(state 0), 노랑(state 2), 초록(state 1)
            g.setColor(state == 0 ? Color.RED : Color.DARK_GRAY);
            g.fillOval(70, 30, 60, 60);
            g.setColor(state == 2 ? Color.YELLOW : Color.DARK_GRAY);
            g.fillOval(70, 110, 60, 60);
            g.setColor(state == 1 ? Color.GREEN : Color.DARK_GRAY);
            g.fillOval(70, 190, 60, 60);
        }
    }
    public static void main(String[] args) { new TrafficLight(); }
}
```

---

## 문제 2. 마우스 클릭 도형 그리기 ⭐⭐⭐

### 📋 요구사항
컨텐트팬을 클릭하면 그 위치에 지름 30인 원을 누적해 그리고, **더블클릭하면 배경색을 랜덤으로** 바꾸시오.
- [ ] MouseListener(또는 MouseAdapter)로 좌표 획득
- [ ] 클릭 좌표를 `Vector<Point>`에 저장 후 `paintComponent`에서 모두 그림
- [ ] `getClickCount() == 2`면 배경색 랜덤 변경

### 💡 출제 의도
MouseAdapter · 좌표 · 더블클릭 · Vector · paintComponent · repaint.

### ✅ 모범답안
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ClickCircle extends JFrame {
    public ClickCircle() {
        setTitle("클릭 원 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(400, 400);
        setVisible(true);
    }
    class MyPanel extends JPanel {
        Vector<Point> points = new Vector<>();
        Color bg = Color.WHITE;
        Random rand = new Random();
        MyPanel() {
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {        // 더블클릭
                        bg = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                        repaint();
                    }
                }
            });
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(bg);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLUE);
            for (Point p : points) g.drawOval(p.x - 15, p.y - 15, 30, 30);
        }
    }
    public static void main(String[] args) { new ClickCircle(); }
}
```

---

## 문제 3. 키보드로 우주선 움직이기 ⭐⭐⭐

### 📋 요구사항
화살표 키로 패널 위의 우주선(삼각형)을 한 번에 15픽셀씩 움직이시오. 화면 밖으로 못 나가게 경계 처리하시오.
- [ ] `setLayout` 없이 paintComponent로 삼각형(`fillPolygon`) 그리기
- [ ] KeyListener + 포커스 설정
- [ ] 상하좌우 이동 + 경계(0 ~ 패널크기) 제한

### 💡 출제 의도
KeyAdapter · 포커스(setFocusable/requestFocus) · fillPolygon · 경계 체크 · repaint.

### ✅ 모범답안
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Spaceship extends JFrame {
    private int x = 200, y = 200;
    private final int STEP = 15, SIZE = 30;
    private MyPanel panel = new MyPanel();

    public Spaceship() {
        setTitle("우주선 조종");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    y -= STEP; break;
                    case KeyEvent.VK_DOWN:  y += STEP; break;
                    case KeyEvent.VK_LEFT:  x -= STEP; break;
                    case KeyEvent.VK_RIGHT: x += STEP; break;
                }
                // 경계 제한
                if (x < 0) x = 0;
                if (y < 0) y = 0;
                if (x > getWidth() - SIZE)  x = getWidth() - SIZE;
                if (y > getHeight() - SIZE) y = getHeight() - SIZE;
                panel.repaint();
            }
        });
        setSize(450, 450);
        setVisible(true);
        panel.setFocusable(true);    // ★ 포커스 (setVisible 뒤)
        panel.requestFocus();
    }
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            int[] px = {x + SIZE/2, x, x + SIZE};        // 삼각형 꼭짓점
            int[] py = {y, y + SIZE, y + SIZE};
            g.fillPolygon(px, py, 3);
        }
    }
    public static void main(String[] args) { new Spaceship(); }
}
```

---

## 문제 4. 체크박스 과일 가격 합산 ⭐⭐⭐

### 📋 요구사항
사과(100), 배(500), 체리(20000) 체크박스를 만들고, 체크 상태에 따라 **총합 가격을 레이블에 실시간 표시**하시오.
- [ ] JCheckBox 3개 + 합계 JLabel
- [ ] ItemListener로 선택/해제 시 합산/차감

### 💡 출제 의도
JCheckBox · ItemListener · `getStateChange()` · `getItem()` 비교.

### ✅ 모범답안
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FruitSum extends JFrame {
    private JCheckBox[] fruits = new JCheckBox[3];
    private String[] names = {"사과(100)", "배(500)", "체리(20000)"};
    private int[] prices = {100, 500, 20000};
    private JLabel sumLabel = new JLabel("현재 0원");
    private int sum = 0;

    public FruitSum() {
        setTitle("과일 가격 합산");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        ItemListener listener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                for (int i = 0; i < 3; i++) {
                    if (e.getItem() == fruits[i]) {
                        if (e.getStateChange() == ItemEvent.SELECTED) sum += prices[i];
                        else sum -= prices[i];
                    }
                }
                sumLabel.setText("현재 " + sum + "원");
            }
        };
        for (int i = 0; i < 3; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].addItemListener(listener);
            c.add(fruits[i]);
        }
        c.add(sumLabel);
        setSize(380, 120);
        setVisible(true);
    }
    public static void main(String[] args) { new FruitSum(); }
}
```

---

## 문제 5. 슬라이더로 원 색·크기 제어 ⭐⭐⭐⭐

### 📋 요구사항
슬라이더 2개로 패널 중앙 원의 **지름(0~300)** 과 **빨강 성분(0~255)** 을 실시간 조절하시오.
- [ ] JSlider 2개 + ChangeListener
- [ ] 슬라이더 값 변경 시 `repaint()`로 원 갱신

### 💡 출제 의도
JSlider · `javax.swing.event.ChangeListener` · `getValue()` · 동적 그래픽 갱신.

### ✅ 모범답안
```java
import javax.swing.*;
import javax.swing.event.*;     // ★ ChangeListener는 여기
import java.awt.*;

public class SliderCircle extends JFrame {
    private int diameter = 100, red = 0;
    private CirclePanel panel = new CirclePanel();

    public SliderCircle() {
        setTitle("슬라이더로 원 제어");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 300, 100);
        JSlider colorSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        sizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                diameter = ((JSlider)e.getSource()).getValue();
                panel.repaint();
            }
        });
        colorSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                red = ((JSlider)e.getSource()).getValue();
                panel.repaint();
            }
        });

        JPanel sliders = new JPanel(new GridLayout(2, 1));
        sliders.add(sizeSlider);
        sliders.add(colorSlider);
        add(panel, BorderLayout.CENTER);
        add(sliders, BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);
    }
    class CirclePanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(red, 0, 0));
            int cx = getWidth()/2 - diameter/2;
            int cy = getHeight()/2 - diameter/2;
            g.fillOval(cx, cy, diameter, diameter);
        }
    }
    public static void main(String[] args) { new SliderCircle(); }
}
```

---

## 문제 6. GUI 좀비게임 + 보물 시스템 (종합판) ⭐⭐⭐⭐⭐

> **중간고사 형식 그대로** — 세 문제로 나뉘어 출제될 가능성이 가장 높은 핵심 문제입니다.

### 📋 요구사항

**<문제 6-1> Gem 클래스 정의**
- 멤버: 이름(name), 번호(number), 위치(x, y)
- 생성자에서 초기화 (예: `new Gem("금", 2, 10, 171)`)
- 보물 종류: 다이아(1)·금(2)·은(3)
- `paint(Graphics g)`로 자신을 도형으로 그림
- 영웅과의 충돌 `crush(int x, int y)` 메소드
- 획득 시 "○○ 을 획득했습니다." 출력하는 `getItem()`

**<문제 6-2> 좀비게임 보물 획득 기능**
- 시작 시 보물 1개를 랜덤 종류·랜덤 위치로 생성, 위치 출력
- 영웅이 보물에 닿으면 `Vector`에 저장 후 콘솔 출력, 새 보물 재생성
- 획득 보물 개수를 화면 좌상단에 `drawString`으로 표시

**<문제 6-3> 저장/이어하기**
- `S` 키: 획득 보물을 파일에 저장
- `L` 키: 파일에서 읽어와 이어서 진행 + 콘솔에 목록 출력

### 💡 출제 의도
클래스 설계(멤버·생성자·메소드) + Thread 게임루프 + KeyListener + paintComponent + 충돌 + Vector + 파일 I/O를 **한 프로그램에 종합**.

### ✅ 모범답안
> **PART 2의 18번 「GUI 좀비게임 완성 템플릿」이 곧 이 문제의 완성 답안입니다.** 그대로 작성하면 6-1(Gem 클래스), 6-2(makeGem + run의 획득 로직 + paintComponent 점수 표시), 6-3(save/load)이 모두 충족됩니다.

핵심 채점 포인트만 다시 정리하면:

```java
// 6-1: Gem 클래스 — 멤버 + 생성자 + paint + crush + getItem (PART 2 참조)

// 6-2: 보물 생성 + 획득 (GamePanel)
void makeGem() {                                  // 랜덤 생성 + 위치 출력
    int idx = rand.nextInt(3);
    int gx  = rand.nextInt(480);
    gem = new Gem(names[idx], idx + 1, gx, 171);
    System.out.println(gx + "위치에 " + names[idx] + "가 있습니다.");
}
// run() 안에서:
if (gem != null && gem.crush(hero.x, hero.y)) {
    myGems.add(gem.name);                          // Vector 저장
    System.out.println(gem.name + "를 획득하였습니다.");
    makeGem();                                     // 재생성
}
// paintComponent() 안에서:
g.drawString("획득 보물: " + myGems.size() + "개", 10, 20);

// 6-3: 저장/이어하기 (S/L 키)  — PART 2의 save()/load() 그대로
```

> **함정 주의**: 직렬화(ObjectOutputStream)로 객체 저장 시, `Image` 같은 직렬화 불가 필드엔 `transient`를 붙여야 합니다. 시험에선 위처럼 **이름(String)만 텍스트 저장**하는 방식이 가장 안전합니다.

---

# PART 4 — 시험장 도구

## ⚡ 채점 기준 체크리스트

GUI 실습 답안에 아래 요소가 들어있는지 확인하세요.

| 항목 | 배점(추정) | 확인 |
|------|-----------|------|
| **기본 골격** | | |
| import 3종 + JFrame 상속 + main() | 5% | ☐ |
| `setDefaultCloseOperation(EXIT_ON_CLOSE)` | 5% | ☐ |
| `setVisible(true)`가 생성자 마지막 | 5% | ☐ |
| **배치/컴포넌트** | | |
| 배치관리자 또는 절대배치(null) 적절히 | 10% | ☐ |
| 요구된 컴포넌트 생성·add | 10% | ☐ |
| **이벤트** | | |
| 올바른 리스너 등록(addXxxListener) | 10% | ☐ |
| `e.getSource()` 캐스팅 정확 | 5% | ☐ |
| 키 이벤트 시 포커스 설정 | 5% | ☐ |
| **그래픽** | | |
| `paintComponent` + `super.paintComponent(g)` | 10% | ☐ |
| 요구 도형/문자열 정확히 그림 | 10% | ☐ |
| 상태 변경 후 `repaint()` 호출 | 5% | ☐ |
| **게임/종합** | | |
| Thread(Runnable) 게임 루프 | 5% | ☐ |
| 충돌 판정 로직 | 5% | ☐ |
| Vector 저장 · 파일 I/O(try-catch) | 5% | ☐ |

### 🎯 만점 받는 팁
1. **요구사항을 주석으로 먼저 나열** → 하나씩 ✅ 체크하며 구현
2. 클래스 이름은 명사(`Hero`, `Gem`), 메소드는 동사(`move`, `draw`, `crush`)
3. 그래픽이 안 보이면 → `super.paintComponent(g)` 또는 `setContentPane`/`add` 누락 의심
4. 키 입력이 안 먹으면 → `setFocusable(true) + requestFocus()`를 **`setVisible(true)` 뒤에** 호출했는지 확인
5. 시간이 촉박하면 **이미지 대신 도형(fillRect/fillOval)** 으로 먼저 통과시키기

---

## 🧩 문제 유형 빠른 판단 가이드

| 문제에 이런 말이 나오면… | 필요한 기술 |
|------------------------|-------------|
| "버튼을 누르면", "선택하면" | **ActionListener** |
| "마우스로 클릭/드래그한 위치에" | **MouseListener / MouseMotionListener** |
| "화살표 키로 움직여라" | **KeyListener + 포커스** |
| "체크/선택 상태에 따라" | **ItemListener** |
| "슬라이더로 값을 조절" | **JSlider + ChangeListener** |
| "원/사각형/선을 그려라", "~모양으로" | **paintComponent + Graphics** |
| "이미지를 그려라" | **drawImage / JLabel(ImageIcon)** |
| "실시간으로", "1초마다", "자동으로 움직임" | **Thread(Runnable) + repaint** |
| "닿으면", "부딪치면", "잡히면" | **충돌 판정(거리/겹침)** |
| "저장", "이어하기", "기록" | **Vector + 파일 I/O** |
| "자유 위치", "게임", "겹쳐서" | **setLayout(null) 절대배치** |
| "여러 종류의 적/캐릭터" | **상속 + 다형성** |

---

## ⚠️ 실수 방지 체크리스트

| 실수 | 해결 |
|------|------|
| 그림이 안 그려짐 / 잔상이 남음 | `paintComponent` 안에 `super.paintComponent(g)` 추가 |
| `paintComponent`를 직접 호출 | 직접 호출 금지 → `repaint()`로 시스템이 호출하게 |
| 키 이벤트가 안 먹음 | `setFocusable(true)` + `requestFocus()` (setVisible 뒤) |
| 컴포넌트가 안 보임 | `c.add(...)` 누락 / `setVisible(true)` 누락 / 위치가 setVisible 전 |
| 게임이 안 움직임 | 스레드를 `run()`이 아니라 `start()`로 시작 |
| `Thread.sleep` 컴파일 에러 | try-catch로 `InterruptedException` 처리 |
| 파일 I/O 컴파일 에러 | try-catch로 `IOException` 처리 |
| `e.getSource()` 사용 시 에러 | 올바른 타입으로 **캐스팅** (`(JButton)e.getSource()`) |
| 라디오버튼이 다중 선택됨 | `ButtonGroup`에 `add` 했는지 확인 |
| 게임에서 위치 이동이 안 됨 | `setLayout(null)` 했는지 / 이동 후 `repaint()` 했는지 |
| ChangeListener import 에러 | `import javax.swing.event.*;` 추가 |
| `==` vs `equals` | 문자열 비교는 무조건 `.equals()` |

---

## 📦 import 치트시트 (복붙용)

```java
// GUI 필수 3종 + 슬라이더 이벤트
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;   // ChangeListener (JSlider)

// 자료구조 / 파일
import java.util.*;           // Vector, Random
import java.io.*;             // BufferedReader/Writer, FileReader/Writer, IOException
```

---

## 🔑 개념 단답 비교표

| 구분 | A | B |
|------|---|---|
| 컴포넌트 무게 | AWT = 중량(native) | Swing = 경량(순수 자바) |
| 자동 호출 메소드 | `paintComponent()` (직접 호출 X) | `repaint()` (개발자가 호출 O) |
| 키 판별 | `getKeyChar()` (문자 키) | `getKeyCode()` (모든 키, VK상수) |
| 선택 컴포넌트 | JCheckBox (다중) | JRadioButton (그룹 중 1개) |
| 리스너 단축 | MouseListener(5개 구현) | MouseAdapter(필요한 것만) |
| 다시 그리기 | `repaint()` (그리기) | `revalidate()` (재배치) |
| 어댑터 존재 | Mouse / Key / Window = 있음 | Action / Item = 없음 |
| 최상위 컨테이너 | JFrame, JDialog, JApplet | (그 외는 JComponent 상속) |
| 스레드 시작 | `t.start()` ✅ | `t.run()` ❌ (그냥 메소드 호출됨) |

---

## 페인팅 메커니즘 (개념 문제 대비)

```java
public void paint(Graphics g) {
    paintComponent(g);   // ① 자신의 내부
    paintBorder(g);      // ② 자신의 외곽
    paintChildren(g);    // ③ 자식들
}
```
- 그리는 순서: **바탕 컨테이너 → 자식** 순으로 내려감.
- 이벤트 처리 순서: 이벤트 발생 → 이벤트 객체 생성 → 리스너 찾기 → 리스너 호출(객체 전달) → 실행.
- main() 종료 후에도 창이 살아있는 이유: **이벤트 분배 스레드**가 살아있기 때문.

---

**시험 잘 보세요! 🍀**
