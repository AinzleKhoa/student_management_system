package sms.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import sms.StudentManagementGUI;
import sms.gui.BackgroundPanel;
import sms.gui.ImagePanel;
import sms.gui.TextBoxPanel;
import sms.gui.ToadPanel;
import sms.utils.FooterLabel;
import sms.utils.HyperlinkLabel;

/**
 * @author Lê Anh Khoa - CE190449
 */
public class MenuGUI extends JFrame {

    private JPanel addButton;
    private JPanel deleteButton;
    private JPanel updateButton;
    private JPanel searchButton;
    private JPanel displayAllButton;
    private JPanel saveExitButton;
    private BackgroundPanel backgroundPanel;
    private ToadPanel toadPanel;
    private TextBoxPanel textBoxPanel;
    private StudentManagementGUI studentManagementGUI;

    public MenuGUI(StudentManagementGUI studentManagementGUI) {
        this.studentManagementGUI = studentManagementGUI;

        setTitle("Student Management System");
        setSize(1600, 950);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = getLayeredPane();

        backgroundPanel = new BackgroundPanel("/resources/images/background_image.png", "/resources/images/FPT_background.jpg", "/resources/images/FPT_logo_university.png");
        backgroundPanel.setBounds(0, 0, 1600, 950);

        toadPanel = new ToadPanel("/resources/images/toad_cropped.png");
        toadPanel.setBounds(0, 700, 280, 220);

        Font textFont = new Font("MV Boli", Font.BOLD, 30);

        textBoxPanel = new TextBoxPanel("/resources/images/textbox_toad.png", "Hello there! What are you planning to do today?", textFont);
        textBoxPanel.setBounds(300, 680, 900, 220);

        Font buttonFont = new Font("MV Boli", Font.BOLD, 25);

        addButton = new ImagePanel("/resources/images/frame_selector.png", "/resources/images/hover_frame_selector.png", "/resources/images/add.png", "Add Student", buttonFont, textBoxPanel, new ActionListener() {
            @Override //Phương thức actionPerformed nhận vào một đối tượng ActionEvent, chứa thông tin về sự kiện hành động.
            public void actionPerformed(ActionEvent e) {
                studentManagementGUI.addStudent();
            } //Phần override là được implements từ MouseListener, mục đích để khi chuột bấm vào nút này thì sẽ tham chiến đến class chính studentMagenement về cái function tương ứng.
        });

        deleteButton = new ImagePanel("/resources/images/frame_selector.png", "/resources/images/hover_frame_selector.png", "/resources/images/delete.png", "Delete Student", buttonFont, textBoxPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManagementGUI.deleteStudent();
            }//Phần override là được implements từ MouseListener, mục đích để khi chuột bấm vào nút này thì sẽ tham chiến đến class chính studentMagenement về cái function tương ứng.
        });

        updateButton = new ImagePanel("/resources/images/frame_selector.png", "/resources/images/hover_frame_selector.png", "/resources/images/update.png", "Update Student", buttonFont, textBoxPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManagementGUI.updateStudent();
            }//Phần override là được implements từ MouseListener, mục đích để khi chuột bấm vào nút này thì sẽ tham chiến đến class chính studentMagenement về cái function tương ứng.
        });

        searchButton = new ImagePanel("/resources/images/frame_selector.png", "/resources/images/hover_frame_selector.png", "/resources/images/search.png", "Search Student", buttonFont, textBoxPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManagementGUI.searchStudent();
            }//Phần override là được implements từ MouseListener, mục đích để khi chuột bấm vào nút này thì sẽ tham chiến đến class chính studentMagenement về cái function tương ứng.
        });

        displayAllButton = new ImagePanel("/resources/images/frame_selector.png", "/resources/images/hover_frame_selector.png", "/resources/images/displayAll.png", "Display All", buttonFont, textBoxPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManagementGUI.displayAllStudents();
            }//Phần override là được implements từ MouseListener, mục đích để khi chuột bấm vào nút này thì sẽ tham chiến đến class chính studentMagenement về cái function tương ứng.
        });

        saveExitButton = new ImagePanel("/resources/images/frame_selector.png", "/resources/images/hover_frame_selector.png", "/resources/images/saveExit.png", "Save & Exit", buttonFont, textBoxPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentManagementGUI.saveAndExit();
            }//Phần override là được implements từ MouseListener, mục đích để khi chuột bấm vào nút này thì sẽ tham chiến đến class chính studentMagenement về cái function tương ứng.
        });

        Font linkFont = new Font("Arial", Font.PLAIN, 18);
        HyperlinkLabel githubLink = new HyperlinkLabel("My Github", "https://github.com/AinzleKhoa", linkFont, 750, 860, 90, 30);

        HyperlinkLabel portfolioLink = new HyperlinkLabel("My Portfolio Page", "https://ainzlekhoa.github.io/portfolio/", linkFont, 850, 860, 150, 30);

        FooterLabel copyright = new FooterLabel("\u00A9 2025 AinzleKhoa", new Font("SansSerif", Font.BOLD, 16), 300, 860, 200, 30);

        int firstLocationX = 0;
        int firstLocationY = -30;
        addButton.setBounds(firstLocationX, firstLocationY, 450, 350);
        deleteButton.setBounds(firstLocationX + 450, firstLocationY, 450, 350);
        updateButton.setBounds(firstLocationX + 900, firstLocationY, 450, 350);
        searchButton.setBounds(firstLocationX, firstLocationY + 345, 450, 350);
        displayAllButton.setBounds(firstLocationX + 450, firstLocationY + 345, 450, 350);
        saveExitButton.setBounds(firstLocationX + 900, firstLocationY + 345, 450, 350);

        layeredPane.add(backgroundPanel, Integer.valueOf(0));
        layeredPane.add(toadPanel, Integer.valueOf(1));
        layeredPane.add(textBoxPanel, Integer.valueOf(1));
        layeredPane.add(addButton, Integer.valueOf(1));
        layeredPane.add(deleteButton, Integer.valueOf(1));
        layeredPane.add(updateButton, Integer.valueOf(1));
        layeredPane.add(searchButton, Integer.valueOf(1));
        layeredPane.add(displayAllButton, Integer.valueOf(1));
        layeredPane.add(saveExitButton, Integer.valueOf(1));

        layeredPane.add(githubLink, Integer.valueOf(2));
        layeredPane.add(portfolioLink, Integer.valueOf(2));
        layeredPane.add(copyright, Integer.valueOf(2));

        setVisible(true); // Hiển thị frame
    }
}
