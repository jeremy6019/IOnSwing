package define;

public class swing2 {
/*
**Pane 
=> 특정목적에 맞게 만들어진 컴포넌트 
1.JEditorPane
=>여러가지 형태의 문서의 내용을 출력할 수 있는 컴포넌트 
=>텍스트파일, html, rtf 문서의 내용을 출력할 수 있습니다. 

1) 생성자 
JEditorPane() : 문서를 출력할 수 있는 컴포넌트를 만들고 나중에 문서를 지정 

JEditorPane(String url):문서파일의 경로를 지정해서 생성 
  
JEditorPane(String type, String text):type을 지정해서 text를 출력 
  
JEditorPane(URL url):문서파일의 경로를 지정해서 생성 - URL 자료형 
  
2) URL, URI, URN 
=>URI(Uniform Resource Identifier):자원을 구별하기 위한 식별자 
URL과 URN합쳐서 URI라고 합니다.

=>URL(Uniform Resource Locator):리소스에 대한 구체적인 위치 
URL을 알면 자원에 접근할 수 있습니다. 
http://www.google.com등 

=>URN(Uniform Resource Name) : 리소스에 대한 구별된 이름 
URL의 한계로 인해서 등장 
URL은 위치지 이름이 아닙니다. 
위치를 변경하면 URL로는 자원에 접근할 수 없습니다. 
구별된 이름을 이용해서 위치가 변경되더라도 자원에 접근할 수 있도록 하기 위해서 등장 

2.JTabbedPane
=>탭을 이용해서 여러개의 페이지를 출력하는 컴포넌트 
1) 생성자
JtabbedPane():탭을 상단에 배치 

JTabbedPane(int placement) :탭의 위치를 성정하는 생성 (TOP, BOTTOM, LEFT, RIGHT)
=>특정한 값만 대입받을 수 있는 경우는 Field Summary에 보면 사용할 수 있는 옵션들이 만들어져 
있을 겁니다. 

 2)화면을 추가 
 add(Component component)
 =>탭에 타이틀을 추가하거나 위치 또는 Icon을 설정하는 옵션들이 포함되는 메소드들이 overloading(메소드의 
 이름은 같고 매개변수의 자료형이나 개수가 다른 경우) 되어 있습니다. 
 
 3) 화면에서 제거 
 remove(Component component) 
 
 4)탭을 사용하는 경우는 하나의 화면에 표시하기에는 컴퍼넌트가 너무 많거나 동일한 데이터를 여라가지방법으로
 사용하거나 출력하고자 할 때 사용하는 것을 권장합니다. 
 
 3. JOptionPane 
 =>메세지 출력이나 선택 또는 한 줄의 텍스트를 입력할 수 있는 대화상자 
 => 대화상자는 단독으로 출력을 하지 않고 자신의 Owner가 있어야 합니다. 
 1) 메세지만 출력하는 대화상자 - JOptionPane.showMessageDialog() 
 
 2) 확인 이나 취소 같은 버튼을 배치해서 선택하는 대화상자 -JOptionPane.showConfirmDialog()
 => 어떤 버튼을 눌렀는지 정수(누른버턴의 값 - Field로 만들어져 있음)로 리턴 
 
3) 한 줄의 텍스트를 입력할 수 있는 대화상자 -JOptionPane.showInputDialog() 
=> 확인을 누르면 입력한 문자열이 리턴되고 취소를 누르면 null이 리턴 

4)메소드의 옵션들로 버튼의 종류나 아이콘 모양을 설정할 수 있습니다.
메소드들이 Overloading되어 있습니다.  

4.Common Dialog -공통 대화상자
=>자주 사용하는 기능의 대화상자를 미리 만들어서 제공 
 1) 파일 열기와 저장에 관련된 대화상자  = JFileChooser 
 =>FileSystemView : 파일 시스템과 디렉토리 정보를 제공 
 =>FileView :파일에 대한 정보를 제공 
 =>FileFilter: 확장자를 제한하기 위한 클래스 
 
 =>생성자 
 JFileChooser():현재 디렉토리를 출력 
 JfileChooser(File currentDirectory):매개변수로 대입된 디렉토리를 출력 
 JfileChooser(String currentDirectory):매개변수로 대입된 디렉토리를 출력 
 
 =>주요메소드
 setMultiSelectionEnabled(boolean b):여러 개 선택 가능하도록 설정 

 showOpenDialog(Frame owner):화면에출력하고 확인이나 취소버튼 누른 것을 리턴 
 확인을 누르면 JFileChooser.APPROVE_OPTION을 리턴 
  
 getSelectedFiles(): 선택한 파일 목록을 File의 배열로 리턴  
 
  =>확장자 제한 
  FileNameExtensionfilter ? = new FileNameExtensionFilter("문자열","확장자");
  setFileFilter(?); 
  
   => 가장 중요한 작업은 대화상자를 출력해서 선택한 파일들의 이름을 확인하는 것 
 
  2) 색상 대화상자 -JColorChooser 
 => 생성은 JColorChooser()또는 JColorChooser(int color)
 => 출력은 showDialog라는 static 메소드를 이용해도 되고 객체를 생성한 후 출력해도 됩니다. 
 이 메소드는 선택한 색상을 리턴합니다. 
 
 **Menu 
 =>JMenuBae, JMenu, JMenuItem(JCheckBoxMenuItem, JRadioButtonMenuItem)으로 구분 
 =>메뉴바를 생성해서 Frame에 부착하고 JMenu는 메뉴바나 메뉴에 부착 
 메뉴 아이템은 메뉴에 부착을 해서 사용 
 =>메뉴아이템을 클릭할 때는 ActionListener로 처리 
 =>메뉴객체에 setMnemonic(int 단축키)을 이용하면 ALT+단축키를 설정 
  
  
  
 
 */
}
