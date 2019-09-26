package define;

public class Stream {
/*
  
  **ByteStream 
  =>바이트 단위로 데이터를 읽고 쓰는 스트림 
  =>텍스트 입출력은 조금 어렵습니다. 
  
  1.InputStream & OutputStream 
  
  =>바이트 단위 입출력을 위한 메소드를 선언해 놓은 추상클래스 
  
  2. FileInputStream & FileOutputStream 
  
  =>파일에 바이트 단위로 입출력하기 위한 스트림 
  => 생성자는 파일의 경로를 문자열로 받거나 File객체로 받는 형태로 만들어져 있습니다. 
  => 기록을 하는 스트림은 입력하는 스트림보다 매개변수가 하나 많은 생성자가 존재하는데 
  이매개변수는 추가모드를 설정하는 boolean변수입니다.
  true를 대입하면 기존내용에 추가하는 것이고 매개변수를 대입하지 않거나 false를 대입하면 
  파일을 새로 만들어서 기록하게 됩니다. 
  =>파일의 경로를 받아서 생성하는 메소드들은 예외처리를 강제합니다. 
  파일의 경로가 잘못되었을 때 또는 파일이 없을 때 처리를 위한 예외처리를 강제합니다. 
 => 파일 , 데이터베이스,네트워크자원은 사용을 하고 나면 반드시 close()를 호출하도록 합니다. 
 이때 close()를 자동으로 해제하도록 하고자 하면 try()의 ()안에서 생성하면 close()를 
 호출하지 않아도 자동으로 close()를 호출해 줍니다. 
 
3. 문자열과 byte[] 	사이의 변환 

1)문자열은 byte[]로 변환 
byte[] getBytes(): 기본 인코딩 방식으로 변환해서 리턴 
byte[] getBytes("인코딩방식")  : 설정한 인코딩 방식으로 변환해서 리턴 

2) byte배열을 가지고 문자열 만들기 
new String(byte배열)
new String(byte배열 , 시작위치, 개수)
new String(byte배열 , "인코딩방식")
new String(byte배열 , 시작위치, 개수, "인코딩방식")

4. utf-8에서 크기 
한글 - 3byte 
그이외의 문자 -1byte 

=> ms949(cp949), euc-kr, utf-8을 제외하고는 한글을 표현할 수 없습니다.
=>mySQL같은 데이터베이스는 설정없이 그냥 설치하면 iso-latin1이라는 인코딩으로 설치됩니다.
이 경우에는 한글을 저장할 수 없게 됩니다. 

**이벤트 라우팅 
=>여러 객체의 이벤트를 하나의 객체를 이용해서 처리하는 방식 
=>라우팅은 최적의 경로를 찾아주는 것 
=>여러 객체의 이벤트를 하나의 객체에서 찾아서 수행한다고 해서 이벤트 라우팅이라고 합니다.
이벤트 라우팅을 할 때 알아야 하는 것은 이벤트 처리메소드의 첫번째 매개변수를 확이하면 
어떤 객체에게 이벤트가 발생했는지 알 수 있습니다. 
Java의 경우는 첫번째 매개변수의 getSource()를 호출하면 이벤트가 발생한 객체의 참조가 전달됩니다. 
Android나 IOS에서는 첫번쨰 매개변수가 이벤트가 발생한 객체의 참조 

**입출력에 버퍼사용

=>Buffer는 임시 기억장치 
=>파일이나 네트워크에 입출력을 하게되면 실제로는 운영체제의 native method를 호출해서 작업을 수행 
=> 여러번에 걸친 입출력을 하게되면 native method가 너무 자주 호출하게 되서 운영체제에 과부하가 걸리거나 
운영체제에서 현재 프로그램을 중지시켜 버릴 수 있습니다. 
=>입출력을 할 때 버퍼를 이용하면 입출력 내용을 버퍼에 모아 두었다가 운영체게가 쉬는 시간이 생기면 한꺼번에
처리해 달라고 할 수 있습니다. 
=>바이트 단위 입력을 받을때는 BufferedInputStream 을 이용할 수 있고 출력을 할때는 
BufferedOutputStream을 사용할 수 있는 사용하기 편리한 메소드를 소유한 PrintStream을 더 많이 사용합니다.
자바에서 표준 출력스트림을 제공하는데 이 표준 출력 스트림이 System.out입니다.
버퍼단위로 입력받는 스트림도 제공하는데 이 표준 입력 스트림이 System.in입니다.   
=> 이 클래스의 생성자들은 다른 InputStream 과  OutputStream을 매개변수로 받아서 생성합니다.
입출력하는 메소드는 다른 ByteStream과 동일하고 PrintStream은 출력할 때 write대신에 print메소드를 
사용할 수 있습니다. 
print는 버퍼에 모아서 한꺼번에 출력하고 println은 바로 출력하고 줄바꿈을 해줍니다, 
printf는 서식에 맞춰서 데이터를 버퍼에 출력하는 역할을 수행합니다. 

** 네트워크에서 파일을 전송을 할때는 PrintStream(송신)이나 BufferedInputStream(수신)을 이용합니다. 

**DataInputStream & DataOutputStream 
=>기본형의 데이터를 송수신하고자 할 때 사용하는  클래스 
=> InputStream 과 OutputStream에는 바이트 단위로 전송하고 읽는 메소드만 만들어져 있습니다.
정수나 실수처럼 byte로 변경할 수 없는 데이터를 읽고 쓸수 없어서 만든 클래스 
=> 실제 사용은 잘 안하는데 정수나 실수를 전송해야 할때 문자열로 만드렁서 전송한 후 다시 문자열로 
읽어내면 정수나 실수를  읽고 쓸수 있기 때문에 대부분은 잘 사용하지 않음 
=> 전송하는 부분은 PrintStream을 이용하면 가능합니다. 

** Character Stream 
=>문자단위로 전송하기 위한 스트림 
=>바이트 단위로 전송을 해서 문자로 변환하는 형태로 문자 전송을 처리하다 보면 인코딩 방식에 따라서 
문자가 제대로 처리되지 않는 경우가 발생해서 문자 단위로 전송할 수 있는 스트림이 필요 
 
 1.Reader 
 =>문자단위로 읽기 위한 메소드를 소유한 추상 클래스 
 void close(): 닫아주는 메소드 
 
 int read(); 한글자를 읽어서 정수로 리턴하고 읽은 데이터가 없으면 음수(-1)리턴 
 
 int read(char[] buf) : buf 의 크기만큼 읽어서 buf에 저장하고 읽은 개수를 리턴하고 릭은 데이터가 없으면 
 -1을 리턴 
 int read((char[] buf, int off, int len) : off부터 len만큼 읽어서 buf에 저장하고,  읽은 개수를 리턴하고 읽은 
 데이터가 없으면 -1을 리턴 
 
 읽은 내용의 크기를 알지 못할 때 분할해서 읽는 로직 
 while(true) { 
     int r = ?.read(); 
     if(r<=0){
        break;
     }
     읽은 데이터 처리 
 }
    
 long skip(lonf n):n만큼 건너뛰고 그 위치를 리턴 
 
 2. Writer 
 =>문자단위로 데이터를 기록하기 위한 메소드를 소유한 추상 클래스 
void close():닫아주는 메소드 

void write(String str): 문자열을 버퍼에 기록 
void write(String str, int offset, int length): 문자열에서 offset부터 length까지 기록 
 
void flush() :버퍼의 내용을 기록 

3. FileReader & FileWriter 
1)FileReader: 파일에 문자열을 읽어오기 위한 스트림 
=> 생성할 때 파일의 경로를 문자열이나 File객체로 대입 
=> 파일이 존재하지 않으면 FileNotFoundException이 발생 

2)FileWriter:파일에 문자열을 기록하기 위한 스트림
=> 생성할 때 파일의 경로를 문자열이나 File객체로 대입하고 존재하는 경우 추가할 것인지를 설정하는 옵션 
이 있습니다. 
=> 파일이 존재하지 않으면 파일을 생성하기 때문에 파일의 경로를 잘못 입력한 경우 
IOException이 발생합니다.  

4.BufferedReader & PrintWriter 
1)BufferedReader 
=>버퍼를 이용해서 문자열을 읽어오는 스트림 
=>매개변수로 다른 입력 스트림을 받아서 생성 
=>줄 단위로 읽는 readLine이라는 메소드가 추가되어 있습니다.
readLine은 한 줄을 읽고 그 내용을 String으로 리턴하는데 읽은게 없으면 null을 리턴 

String Builder sb = new StringBuilder(); 
while(true){ 
    String line = br.readLine();
    if(line == null){
        break;
    } 
    sb.append(line + "\n"); 
 }
 //읽은 내용은 sb.toString() 

2)PrintWriter
=>버퍼를 이용해서 내용을 기록하는 문자스트림 
=> BufferedWriter대신에 사용하는 이유는 print메소드를 가지고 있어서 사용하기 편리하기 때문 
=> File, file과 encoding방식, OutputStream, String fileName, Writer의 하위 클래스 객체 등을
 가지고생성 
=> 기록은 write와 print메소드를 이용하고 버퍼의 내용을 비우는 것은 flush()입니다. 

  Main :실행 
  View(Window) : 화면 
  Model(EventHandler): 작업 
  => 버튼을 2개 만들어서 1개는 BufferedReader를 이용해서 문자를 읽어와서 출력할 것이고 
  1개는 PrintWriter를 이용해서 입력한 내용을 출력 
 
  1.버튼을 생성 
  
  2. 버튼의 이벤트를 처리할 객체와 버튼을 연결 
  
  3.버튼을 눌렀을 때 수행할 내용을 작성 
  
**웹서버의 로그파일을 읽어서 트래픽의 합계 구하기   
1. 서버의 로그파일을 읽을 수 있어야 합니다. 
 BufferesdReader br = new BufferesReader(new FileReader("파일경로));
 
while(true) {
  // 줄단위로 읽기 
    String line = br.readLine(); 
    If(line == null){
      break; 
    }
    // line이 한줄의 문자열 
  }
  2. String의 분할을 위한 메소드 
  1)특수한 기호로 분할하는 메소드 
  String[] split("분할할기호"); 기호 단위로 분할해서 배열로 리턴 
  
  2) 위치를 기준으로 분할하는 메소드 
  String subString(int start_): start부터 전부 분할 
  String subString(int start, int end+1):start부터 end까지만 분할해서 리턴 
  => subString을 볼때는  두번째  매개변수르 확인하는 습관을 갖도록 하세요 
  어떤  언어는 두번째 매개변수가 위치가 아니고 개수인 경우가 있습니다. 
  
  3. 문자열을 정수로 변경해주는 메소드 
  Integer.parsrInt(String str): str을 정수로 변경해서 리턴하는데 변경에 실패하면 NumberFormationException
  이 발생합니다. 
  
  로그에서 첫번째  데이터는 접속한 클라이언트의 IP입니다.,
  접속한 클라이언트들을 중복없이 출력하고 몇개의 IP에서 접속했는지 출력 
  
  ** 연습문제 - Map을 이용하면 조금 쉽게 할 수 있습니다. 
  IP별 접속횟수 출력하기 
  각 IP별 트래픽의 합계 출력하기 
  
  ** Serializable: 반드시 기억 
  =>객체 직렬화로 번역을 하는데 클래스의 객체를 파일이나 네트워크의 스트림에 전송을 할 수 있도록 해주는
  인터페이스 
  => 모든 인터페이스는 추상메소드를 소유하고 있어서 인터페이스를 implements하면 어떤 메소드를 재정의
  해야하는데 Serializable만은 implements만 하면 구현이 됩니다. 
  => 이인터페이스가 구현된 클래스의 객체는 객체 자체를 스트림에 사용할 수 있습니다. 
  => 응용프로그램을 만들때나 통신을 할 때 이기능을 사용 
  => 안드로이드 같은 경우는 이 인터페이스가 구현되지 않은 객체는 화면끼리 주고받을 수 없습니다. 
  
  ** ObjectInputStream & ObjectOutputStream 
  => Serializable인터페이스를 구현한 객체를 읽고 쓰기 위한 스트림 
  => 객체생성은 다른 InputStream이나  OutputStream을 매개변수로 받아서 생성 
  => 읽는 메소드는 Object readObject() 메소드를 이용해서 1개의 객체를 읽어오는데 리턴타입이 Object입니다. 
  출력을 할 때를 제외하고는 기록할 때 사용한 자료형으로 형 변환해서  사용해야 합니다. 
  => 기록을 하는 메소드는 void writeObject(Serializable Object)메소드를 이용합니다. 
  Serializable인터페이스를 구현하지 않은 클래스의 객체를 대입하면 CastException이 발생합니다. 
  Serializable로 형변환 할 수 없다는 예외입니다.
  => 이 클래스를 이용해서 기록을 하게 되면 원래의 클래스가 없으면 제대로 읽어내지를 못합니다. 
  
  
  
  
  
 
 */
	
	
}
