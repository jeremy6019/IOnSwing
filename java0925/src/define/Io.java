package define;

public class Io {
/*
  
**IO(Input & Output -입출력) 
=>Local에 있는 파일 시스템에 입출력하는 것과 네트워크에 있는 컴퓨터에 입출력하는 것을 포함 
=>java.io 또는 nio패키지를 이용합니다. 

  **File클래스 
 => 파일에 대한 정보를 제공하는 클래스 
 1. 생성자
 File(String 파일경로)
 
 File(String parent, String child):디렉토리 이름과 파일이름을 별도로 대입해서 생성 
 
 File(File parent, String child) 
 
 2.주요 메소드 
 boolean exists():파일의 존재여부를 리턴 
 boolean delete():파일을 삭제 
 
 long lastModified():파일의 수정시간을 정수로 리턴 (1970년 1월1일 자정부터 지나온 밀리초) 
 long length():파일의 길이 
 
 String[] list():디렉토리인 경우 내부에 포함된 디렉토리와 파일의 이름을 문자열 배열로 리턴 
 
 boolean renameTo(File dest):파일의 이름 변경 
  
 3.서버에서 파일을 다운로드 받아서 사용하는 애플리케이션 제작시 알아둘 내용 
 1)파일의 존재 여부를 확인해서 파일을 다운로드 받을 지 결정 
 
 2) 업데이트 
 파일이 존재하는데 업데이트를 해야하는 상황에 대한 판단은 파일의 존재여부를 확인하고 파일의 마지막
 수정 날짜나 크기를 조사해서 업데이트를 수행 
 
 3) 기존 파일을 보전하면 업데이트해야 하는 경우 
 기존파일의 이름을 변경하고 새로운 파일을 만들어서 시작  
 파일이름 만들 때 날짜를 가지고 파일 이름을 만드는 것을 고민해봐야 합니다. 
  
 **파일 대화상자를 이용해서 파일을 선택하고 파일에 대한 정보를 출력 
 =>파일의 존재여부도 확인해보고 이름도 변경  

**Path클래스
=>java.nio.file.Path 클래스 
 => 기존 File클래스의 제약때문에 새로 추가 
 nio패키지는 io패키지보다 나중에 만들어서 추가한 패키지 
 => 최근에 권장하는 것은 Path클래스를 이용해서 작업을 하다가 과거의 API를 사용할 때는 File로 변경해서
 사용하는 것입니다.   
 
  1. 객체 생성 
  Paths.get("파일 경로");
  
  2. 주요 메소드 
  =>String toString():파일의 전체 경로를 문자열로 리턴 
  File toFile():file객체를 리턴 
  URI toUri(): URI를 리턴 
  String getParent():부모경로를 리턴  
  
  3. 파일이나 디렉토리 작업은 Files 클래스의 static메소드 이용 
  Files.copy()는 파일을 복사 
  Files.delete()는 파일을 삭제 
  Files.createFile() 는 파일을 생성 
  Files.createDirectory()는 디렉토리를 생성 
  
  4. 임시 파일 생성 
  =>많은 데이터를 가져와야 할때 메모리에 계속 저장하면 메모리가 부족해서 메모리 부족예외가 
  발생할 수 있습니다. 
  이런 경우에는 중간중간 임시파일에 내용을 출력해두고 읽어오는 것이 좋습니다. 
  =>임시파일을 만들때는 
  Files.createTempFile(Path path, String pre, String ext)로 생성할 수 있습니다. 
  첫번째 매개변수는 파일의 경로이고 두번째 매개변수는 임시파일에 파일에 붙일 접두어이고 세번째 매개변수
  는 확장자 입니다. 
  Path에는 디렉토리 경로를 적고 ext는 .tmp를 많이 사용합니다. 
  =>임시디렉토리도 생성 가능 - Files.createTempDirectory 
  
  **java.io.Stream
  =>1.8에서 추가된 Stream API는 함수형 프로그래밍(빅 데이터 처리 - Map reduce Programming)을 구현하기 위해서 추가된 API이고
   java.io.Stream은 입출력을 위한 Stream API입니다. 
   =>java.io.Stream에서 의미하는 Stream은 입출력을 하기 위해 만든 데이터의 통로입니다. 
   눈에 보이지는 않지만 파일을 읽거나 쓸때 네트워크를 통해서 데이터를 전송하거나 전송받아올 때 통로를 
   만들어서 데이터를 주고 받습니다. 
   
    1.스트림의 분류 
    1)주고 받는 방향에 따른 분류 
    =>inputStream(읽어오는 것)과 OutStream(기록하거나 전송하는 것)
    
    2) 데이터의 형태에 따른 분류 
    =>ByteStream(바이트 단위 전송)과 CharacterStream(문자단위 전송-바이트 단위 전송의 특별한 형태)
    문자 단위 전송은 바이트를 모아서 문자단위로 해석을 하는 것입니다. 
   
   2.스트림의 특징 
   =>스트림 전송은 FIFOFirst In First Out)방식 
   => 스트림은 단방향성 - 입력 스트림을 출력 스트림으로 사용 못함 
   입출력을 하고자 하면 입력과 출력 스트림 2개를 만들어야 합니다.
   => 스트림이 동작하는 동안은 Blocking상태가 되서 CPU사용을 해제합니다.
   입출력을 하고 있을 때는 다른 스레드가 동작할 수 있습니다. 
   작업의 종류가 많은 프로그램을 만들때는 입출력하는 동작은 별도의 스레드로 만드는 것이 좋습니다.
   안드로이드는 네트워크 입출력을 할 때 스레드를 사용하지 않으면 안됩니다. 
   IOS는 권장사항 입니다. 하지않으면 마켓에서 검수를 할 때 거부되는 경우가 있습니다. 
  
  3. 스트림클래스 
  InputStream (바이트 단위 입력)
  -FileInputStream:파일에서 읽어오기 	
  -ObjectInputStream: 객체단위로 읽어오기 
  -buffferedInputstream: 버퍼링을 이용해서 읽어오기 
  
  OutputStream(바이트 단위 출력)
  -FileOutputStream:
  -ObjectOutputStream: 
  -buffferedOutputstream -> PrintStream
  
  Reader(문자단위 입력)
   -FileReader: 파일에서 문자단위로 읽기 
  -buffferedReader: 문자 단위로 읽기를 하는데 버퍼링을 사용 
   
  Writer(문자 단위 출력)
    -FileWriter
    -BufferedWriter: PrintWriter 
  =>맨앞의 클래스 4개는  추상클래스 
  => Buffer라는 단어가 들어가면 자신이 직접 입출력하는 것이 아니고 다른 입출력 스트림을 매개변수로 
  받아서 사용하고 모아서 처리 
 
 **byteStream 
 =>byte단위로 읽고 쓰기 위한 스트림 
 
 1. InputStream 
 => 바이트 단위로 데이터를 읽 기위한 메소드를 선언한 추상 클래스 
 =>int available():읽을 수 있는 바이트수 리턴 
 =>voidclose(): 스트림을 닫는 메소드 
 
 int read() 1바이트 잀어서 정수로 코드를 리턴 
 
 int read(byte[] b): b 바이트 만큼 읽어서 b에 저장하고 읽은 바이트수를 리턴하는 메소드 
 데이터를 읽지 못하면 음수(-1)를 리턴 
 
 int read(byte[] b, int off, int len):off위치부터 len만큼 ㅣㅇㄹㄱ어서 b에 저장하고 읽은 바이트 수를 리턴하는 
 메소드 
 데이터를 읽지 못하면 음수를 리턴 

 => long skip(long n): n만큼 건너뛰는 메소드 
 
  2.OutputStream 
  =>바이트 단위로 기록하기 위한 메소드를 선언한 추상 클래스 
  =>void close(): 닫기 
  void write(int n) :n을 기록 
  void write(byte[] n): 배열을 기록 
  void write(byte[] n, int off, int len):n배열에서 off	부터 len만큼 기록 
  
  void flush(): 버퍼의 내용을 호출하는 메소드 
  
  => 기록을 하고나면 flush를 호출해서 버퍼의 내용을 출력해야만 정확한 기록이 이루어 집니다., 
  
  3.String과 byte[]사이의 볂솬 
  1) String 을 byte[]로 만들기 
  getByte()호출 
  인코딩 방식을 설정해서 호출하는 것도 가능 
  
  2)byte[]을 가지고 String만들기 
  new String(byte[])을 이용해서 객체생성 
  인코딩방식을 설정해서 만드는 것도 가능 
  
  3) 인코딩 방식을 사용하는 경우는 서로 다른 운영체제 또는 다른 컴퓨터에서 데이터를 같이 사용하고자 할 때 
  사용합니다. 
  
  4.fileInputStream & fileOutoutStream 
  1)FileInputStream 
  =>파일에서 바이트 단위로 읽어오기 위한 스트림 클래스 
  => FileInputStream(String파일경로) 또는 fileOutputStream(File파일)로 생성 
  
  2) fileOutputStream 
  =>파일에 바이트 단위로 기록을 하기 위한 스트림 클래스 
  => FileOutputStream(String파일경로) FileOutputStream(File파일)와 
  뒤에 추가여부를 boolean으로 생성할 수 있는 생성자로 객체를 생성 
  
  
  
  
  
 
 */
}
