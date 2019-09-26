package define;

public class InterfaceInnerclass {

	/*
	 
    ** interface 
    - 추상메소드 와 final상수 만을 가진 것
    - 메뉴얼의 역할을 하기 위해서 생성 
    - interface를 implements(구현)하게 되면 interface에 있는 메소드들을 반드시 구현해야 하기 때문에 
      interface를 implements하게 되면 어떤 메소드가 있다는 것을 보장할 수 있습니다.  
    
    1. 생성 
    interface 인터페이스 이름 extends 다른 인터페이스 { 
      메소드를  선언 
      변수를 선언
     }
     - 메소드를 선언할 때 abstract를  붙이지 않아도 abstract가 있는 것으로 간주
     - 변수를 만들 때 final을 붙이지 않아도 final(변수 앞에 final이 있으면 변수의 값을 변경할 수 없음)
        이 있는 것으로 간주 
     
     2. 다른 클래스가 인터페이스를 가져다 사용하는 방법 
       class 클래스 이름 extends 상위클래스 이름 implements인터페이스 이름1 , 인터페이스이름2...{
       //추상메소드 overriding 
       }
      - 클래스는 1개만 상속 가능 (단일 상속)
      - 인터페이스는 여러 개 구현 가능
      
     3. 인터페이스는 메뉴얼이나 메뉴판의 역할이지 다중 상속이 아닙니다. 
        개발자와 기획자 또는 고객과의 대화의 수단입니다. 
     
        4. 인터페이스도 내용이 없기 때문에 객체생성은 못합니다. (new를 못합니다. ) 
        인터페이스타입의 변수를 만들 수 있습니다.
        인터페이타입으로 변수를 만들면 인터페이스를 implements한 클래스의 객체참조를 대입할 수 있습니다. 
        
        패키지를 만들어서 인터페이스 사용 
        1. 데이터를 삽입(Create)하고 읽고(Read)수정하고(Update)삭제하는(Delete) 메소드를 가진 Service 인터페이스를 생성 
       
          //데이터를 삽입하는 메소드 
			public void insert();
			//데이터를 읽어오는 메소드
			public void read(); 
			//데이터를 수정하는 메소드 
			public void update();
			//데이터를 삭제하는 메소드 
			public void remove(); 
			
         2. Service인터페이스를 implements한 ServiceImpl클래스를 생성 
	          - 직접 implements 해도 되지만 Eclipse에서 class를  생성할 때 implements하면 추상메소드가 전부 만들어 집니다. 
             - 어떤 인터페이스나 추상클래스를 상속받았을 때 메소드를 구현하지 않았다고 에러가 발생하면 클래스이름에 커서를 두고 
               Add unimplemented method를 클릭하면 메소드의 모양을 전부 만들어 줍니다. 
			    
			    public class ServiceImp implements Service {
			
				@Override
				public void insert() {
				    System.out.printf("데이터 삽입\n");		
				    
				}
			
				@Override
				public void read() {
					 System.out.printf("데이터 읽기\n");		
					 
				}
			
				@Override
				public void update() {
					 System.out.printf("데이터 수정\n");		
					 
				}
			
				@Override
				public void remove() {
					 System.out.printf("데이터 삭제\n");		
					 
				}
			
				
				
			}

         3. main 메소드를 소유한 Main클래스를 생성해서 인터페이스의 메소드를 사용 
           
         public class Main {

			public static void main(String[] args) {
				// ServiceImp객체를 생성 
			   // ServiceImp service = new ServiceImp();
				
			    // 인터페이스를 implements한 클래스의 객체를 만들 때는 
			    // 변수를 만들 때  인터페이스 이름을 사용하기도 합니다. 
			    Service service = new ServiceImp(); // 관습 
			    service.insert();
			    service.read();
			    service.update();
			    service.remove();
			    
			}
		
		} 
   
   4. 이런 형태의  interface에 필요한 메소드의 모형을 만들고 실제구현은 class에서 하는 방식을 Template Method Pattern
       이라고 합니다. 사용자의 요구사항을 구현할 때 이런 방식을 주로 이용합니다. 
       
   
   ** 인터페이스 기타 문법 
    - 인터페이스도 다른 인터페이스에게 상속 가능 
       implements대신에 extends를 사용 
    - 특별한 인터페이스는 implements하는 것만으로 내용이 구현되는 경우가 있습니다. 
       대표적인 인터페이스가 java.util.Serializable 
    - 인터페이스에 내용을 가진 메소드를 생성할 수 있습니다. 
      접근지정자를 명시적으로 default를 사용하면 됩니다. 
      
   ** final 
   1. final class: class앞에 final을 기재하면 상속할 수 없는 클래스가 됩니다. 
   
   2. final method: method의 결과형 앞에 final을 기재하면 이 메소드를 overriding할 수 없습니다. 
   
   3. final variable: 변수 앞에 final을 기재하면 변수의 값을 수정할 수 없는 읽기 전용이 됩니다. 
   - final class나 final method를 만드는 이유는 시스템과 관련된 클래스나 메소드라서 상속을 하거나 오버라이딩을 하면 
      문제가 발생할 수 있기 때문입니다. 
   
  ** class 들 사이의 관계 
  - 하나의  프로젝트 또는 패키지에 모인 클래스들은 서로 간에 관계를 가져야 합니다. 
   1. is a: 상속 관계 
  
   2. has a : 하나의 클래스가 다른 클래스의 객체를 포함하고 있는 경우  
     1) aggregation relation: 포함하는 객체와 포함되는 객체의 수명이 다른 경우로 메소드 내에서 다른 객체가 만들어지는 경우 
     2) composite relation: 포함하는 객체와 포함되는 객체의 수명이 같은 경우 
    
  ** inner class(내부 클래스)
  - java는 클래스안에 다른 클래스를 만들 수 있습니다. 
  - 종류는 일반inner class, static inner class, local inner class, anonymous class 
  - 제일 많이 사용되는 것은 anonymous class 그리고 그다음은 일반 inner class 
     이 클래스들을 많이 사용하는 분야는 GUI(Graphic User Interface) Programming에서 이벤트 처리하는 부분입니다. 
     
     1. inner class
     - 클래스안에 클래스를 만드는 것 
     - 이 클래스는 클래스 안에서만 사용이 가능합니다. 
     public 클래스로 만들어지면 외부 클래스의 객체를 통해서 접근도 가능 
     
     2. static inner class 
     - inner class안에 static 멤버가 있으면 일반 inner 클래스로 만들면 에러 발생 
        이런 경우에는 inner class를 만들때 class앞에 static을 붙여주면 됩니다. 
        
     3. local inner class
     - local은 영역내에서만 사용 가능한 것을 프로그래밍에서는 local이라고 합니다. 
     영역은 일반적으로 method, 제어문, 예외처리구문입니다.
     local에 만든 것은 자신의 영역이 소멸되면 자동으로 소멸됩니다. 
     일반 inner class를 만드는 경우는 한 번 만들어지면 프로그램이 끝날때까지 메모리에서 소멸되지 않지만 
     local에 만든 것은 자신의 영역이 끝나면 자동 소멸됩니다.  
     
     4.Anonymous class (익명개체)
      - 클래스를 만들지 않고 객체를 바로 만들어서 바로 사용하는 문법을 제공 
      - 클래스나 인터페이스를 상속하거나 구현할 때 사용가능 
      - 한 번 만 사용하거나 특정 영역에서만 사용되는 경웅 클래스를 만들어서 작업을 하게되면 메모리 낭비가 
         생길 수 있어서 익명객체를 사용합니다.      
        (Anonymous class) : 이벤트 처리할때 많이 사용 
       
        new 클래스 이름 또는 인터페이스이름 ( ){
              필요한 메소드 재정의  
              
          };
          1) Thread 클래스를 상속받아서 run메소드재정의 
          public class ThreadEx extends Thread {
		    @Override 
		    // 이메소드가 상위 클래스의 메소드를 재정의
		    // 했다는 것을 알려주기 위한 어노테이션 
		    // 어노테이션을 추가했는데 상위 클래스에 메소드가 없으면 에러 
		    public void run() {
		    	for(int i=0; i<5; i++) {
		    		System.out.printf("클래스 생성\n");
		    	}
		    }
		}
      2) main메소드에서 만든 클래스의 인스턴스를 만들고 start()호출 
        Thread th = new ThreadEx(); 
         th.start(); 
         
      3) main메소드에서 클래스를 만들지 않고 앞에했던 작업과 동일한 작업 수행하기 
       // 익명객체를 이용해서 구현 
		Thread th1 = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
		    		System.out.printf("익명 객체 \n");
			   }
			}	
		};
		th1.start();
		
		- 클래스를 만들고 인스턴스를 만들면 클래스를 이용해서 2개이상의 인스턴스 생성이 가능
		  인스턴스를 하나만 만들어서 사용하는 경우 이 방식은 공간 낭비가 될 수 있습니다. 
		  클래스는 한 번 메모리 할당을 받으면 절대로 소멸되지 않는 static한 존재이기 때문 
		 
		- 익명개체를 만들어서 사용하면 2개의 인스턴스를 만들고자 하면 2번 작성해야 합니다.  
           메모리 정리를 하지 않더라도 변수가 소멸되면 메모리에서 자동소멸됩니다. 
           한 번만 사용되는 경우 메모리를 절약할 수 있습니다. 
       
        - java에  GUI(awt, swing)프로그래밍이나 이벤트 처리에서는  anonymous class를 많이 사용하고
          그 이외의 경우는 상속받는 클래스를 만드는 방식을 많이 사용 
        
     
     CLI( Command Line Interface- 명령어 입력하는 방식 )
    
    *** 중요 패키지 
    1. java.lang: 자바의 기본 클래스들이 있는 패키지 
       import하지 않아도  import가 된 것으로 간주 
       => String, System... 
    
    2. java.util: 자료구조 클래스와 Scanner, Random 등 
    
    3. java.text: format(숫자,날짜 등)에 관련된 클래스 
    
    4. GUI프로그래밍 : java.awt, javax.swing, java.awt.event 등 
       => javax는 1.2 버전 이후에 등장한 패키지 
    
    5. java.io, java.nio: 입출력 관련 패키지(컴퓨터에서 입력받고 출력하는 클래스), 파일관련 클래스 
    
    6. java.net: 네트워크 관련 패키지 
    
    7. java.sql: 데이터 베이스 관련 패키지 
    
    ** class앞에 붙는 단어 
     1. abstract: 상속을 통해서만 사용가능한 클래스 
    
     2. final: 상속을 할 수 없는 클래스 
     
     ** interface
     => implements해서 사용해야하는 개체 
     
     ** class의 내용을 확인 
     1. Field Summary: static final 상수 
      => 클래스 안에  만들어진 메소드에 사용하는 옵션들 입니다. 
      => 클래스이름.상수이름
      => 상수이름은 대문자 
      
     2. constructor(생성자)
     - 인스턴스를 만들때 사용하는 메소드 
     - new 생성자이름매개변수)의 형식으로 호출 
     - 생성자가 없는 경우 
     interface 나 abstract class: 인스턴스 생성을 할 수 없기 때문에 생성자가 없음 
     모든 메소드가 static인 경우: 인스턴스를 생성할 필요가 없기때문에 생성자를 private으로 숨겨놈 
     싱글톤패턴(객체를 1개만 생성하는 클래스)과 같은 디자인 패턴 적용: 자신의 이름뒤에 Builder라는 
        이름의 클래스를 이용해서 객체를 만들거나 자신의 static메소드 중에 자신의 자료형을 리턴하는 메소드가
        있습니다. 이메소드를 이용해서 객체를 생성 - java.lang.runtime  
     
     3. Method 
     1) static의 존재 여부 확인: static이 없으면 인스턴스(객체)를 생성해서 호출 
     2) 매개변수(arguments)를 확인 
     3) 메소드에 throws를 있는 지를 확인 
     => throws가 있으면 예외처리를 해주어야 합니다.
     실행하다가 문제가 발생해서 멈추는 것 
     예외처리를 하게되면 멈추지 않고 계속 수행이 가능     
     4) return type을 확인 
       => 메소드가 수행하고 결과를 돌려줄 때 돌려주는 데이터의 자료형 
       void이면 아무것도 돌려주지 않음 
       그 이외의 자료형이면 그 결과를 가지고 다음 작업을 할 수 있습니다. 
      
       5) 메소드 영역하단의 Methods inherited from class 이름 부분을 확인 
       => 상위클래스에서 만든 메소드 그대로 사용 
       => 상위클래스의 메소드 중에서 여기 없는 메소드는 overriding을 해서 기능을 변경한것입니다. 
       
       ** Eclipse에서의 Git Hub사용 
        => Git Hub: 소스 코드 버전관리(형상 관리 - 변경 사항을 관리)을 위한 사이트
        소스코드를 올리면 google에서 검색됩니다.
        검색 안되도록 하려면 private으로 올려야 합니다. 
        => Eclipse에서 할때는 설치하지 않아도 되지만 Android Studio할때는 git을 설치행 합니다.
        git을 설치할 때는 http://www.git-scm.com에서 다운로드 받아서 설치 
        x-Code에서도 설치하지 않고 바로 사용 가능 
	     
	     1. Eclipse Project를 git에 Upload
	     1) git Hub 사이트에서 repository를 생성 
	     2) 생성한 repository 의 url복사 
	     https://github.com/jeremy6019/inheritance.git
	     3) eclipse에서 git의 메뉴를 보기위해서 perspective를 git으로 변경 
	     => perspective는 어던 작업을 할것인지를 선택할 수 잇는 창으로 메뉴가 변경됩니다. 
	     	[Widows] - [Perspective] - [Open Perspective] - [Other]를 선택한 상태에서 Git을 선택합니다.
	     	
	     4) 보이는 화면에서 [Clone a Git repository]를 선택 - 나머지 메뉴는현재 컴퓨터에 저장하는 메뉴 
	     
	     5) 보이는 창에서 URI에 자신의 Git Repository주소가 입력되었는지 확인하고 다른 주소 이거나 비어 있으면 
	     	 붙여넣기 하고 next를 누르면 branch를 확인할 수 있습니다.
	     	 next를누르면 로컬에 저장되는 디렉토리를 확인할수 있습니다.
	     	 다른 디렉토리에 저장하고자 하면 변경하면 됩니다. 
	     
	     6) 여기까지 수행하면 Eclipse와 저장소를 연결한 것입니다. 
	     
	     7) Upload할  프로젝트를 선택 - 프로젝트가 안보이면 perspective를 java로 변경 
	     
	     8) 마우스 오른쪽을 클릭하면 [Team] - [Share Project] 를 선택 
	     
	     9) 다음 화면에서 보이는 창에서 Repository를 선택하고 finish를 클릭
	     -현재 프로젝트를 repository에 연결
	     - 이제부터는 코드가 변경되거나 파일을 만들면 -> 표시가 보입니다. 
	     
	     10) 한 번 업로드하고나면 여기서 부터 시작입니다. 
	         프로젝트를 선택하고 마우스 오른쪽을 클릭하고 [Team] - [Commit]을 선택 
	     
	     11) 하단 창의 모양이 변경되고 3개 영역이 보입니다. 
	     왼족 상단은 업로드 되지 않았거나 변경이 된 파일이 보이고 왼쪽 하단은 수정할 파일을 선택 
	     오른쪽창은 메세지를 적는 창인데 메세지를 적지 않으면 업로드 안됩니다. 
	     메세지는 날짜와 작성자 그리고 작업내용을 기재 
	     
	     12) 작성이 다되면 commit and push를 눌러야 업로드 됩니다. 
	    commit을 누르면 현재 컴퓨터에만 수정이 됩니다. 
	    
	    13) 창이 보이고 git hub 아이디와 비밀번호를 입력하면 upload됩니다. 
	     
	     2. Git hub에서 프로젝트 가져오기 
	     1) git Hub에서 가져올 프로젝트의 URL복사 
	     
	      2) [File] - [Import] - Git 을 선택 
	      
	      3) 
	     
	     
	     
    
       
       
       
       
       
       
       
       
        
  */
}
