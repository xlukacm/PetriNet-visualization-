package fei.stuba.sk.graphics;

import fei.stuba.sk.Buttons.PlaceButton;
import fei.stuba.sk.generate.*;
import fei.stuba.sk.zadanie.PetrisNet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.xml.bind.*;
import java.io.InputStream;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import static javafx.application.Platform.exit;

public class Frames  extends Frame implements ActionListener {

    MenuItem ExitItem;
    MenuItem OpenFile;
    MenuItem NewFile;
    MenuItem SaveAsFile;
    TextArea Edit;

    private Document dokum = new Document();
    private PetrisNet petrisNet= new PetrisNet();
    private List<Elements> element = new LinkedList<>();
    private CanvasNet canvasNet = new CanvasNet(element);

    PlaceButton button1 =  new PlaceButton(element,canvasNet,dokum);
    JToggleButton button2 =  new JToggleButton("Transition");
    JToggleButton button3 =  new JToggleButton("Arc");
    JToggleButton button4 = new JToggleButton("Remove");
    JToggleButton button5 =  new JToggleButton("Run");

    ButtonGroup group = new ButtonGroup();



    public Frames() throws HeadlessException {
        super("Editor ");

        MenuBar bar = new MenuBar();
        setMenuBar(bar);    //menu na polozky z menu

        Menu file = new Menu("File"); //nazov menu

        NewFile = new MenuItem("New");
        NewFile.addActionListener(this);
        file.add(NewFile);

        OpenFile = new MenuItem("Open");    //pridavanie polozok do menu
        OpenFile.addActionListener(this);
        file.add(OpenFile);

        SaveAsFile = new MenuItem("Save as");
        SaveAsFile.addActionListener(this);
        file.add(SaveAsFile);


        ExitItem = new MenuItem("Exit");
        ExitItem.addActionListener(this);
        file.add(ExitItem);
        bar.add(file);        //pridanie nasho file do baru vo frame*/


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);   //dispose()
            }
        });
        setSize(1200, 600);

        setLayout(new BorderLayout()); //rozdelenie framu na casti

        Panel panelUp = new Panel();                                           //panel je miesto na frame kde pridame farbu a tlacidla
        panelUp.setBackground(new Color(218, 239, 255));
        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); //este raz delime nas vrchny layout aby sme pridali do stredu buttons
        panelUp.add(button1);
        button1.addAddListener(this);
        panelUp.add(button2);
        button2.addActionListener(this);
        panelUp.add(button3);
        button3.addActionListener(this);
        panelUp.add(button4);
        button4.addActionListener(this);
        panelUp.add(button5);
        button5.addActionListener(this);
        add(panelUp, BorderLayout.NORTH);

        setVisible(true);

        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
        group.add(button5);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)    //co ma robit po stlaceny mysou alebo zapnuti
    {

//        if (e.getSource() == NewFile){
//
////            Document docum = new Document();
////            TransformGraphic graf = new TransformGraphic();
////            PetrisNet petrisNet = new PetrisNet();
////            TransformNet tranNet = new TransformNet();
////           // element = graf.transform(petrisNet,docum);
////
////            CanvasNet canvas = new CanvasNet(element, docum, this);
////            //CanvasNet canvas = new CanvasNet(graf.transform(petrisNet,dokum),dokum,this);
////            add(canvas,BorderLayout.CENTER);
////            setVisible(true);
//            try {
//                InputStream resource = ClassLoader.getSystemResourceAsStream("new.xml");
//            JAXBContext context = JAXBContext.newInstance(Document.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//
//            Document docum = (Document) unmarshaller.unmarshal(resource);
//
//            TransformGraphic graf = new TransformGraphic();
//            TransformNet tranNet = new TransformNet();
//
//            CanvasNet canvas = new CanvasNet(graf.transform(tranNet.transform(docum), docum), docum, this);
//            add(canvas,BorderLayout.CENTER);
//            setVisible(true);
//
//        } catch (JAXBException el) {
//        el.printStackTrace();
//    }
////            catch (FileNotFoundException el) {
////                System.out.println("nic sa nenacitalo");
////            }
//
//        }

        if (e.getSource() == ExitItem) {
            System.exit(0);
        }

        if (e.getSource() == OpenFile) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open file");
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
            fileChooser.addChoosableFileFilter(xmlfilter);

            int ret = fileChooser.showOpenDialog(null);//namiesto null bolo frame

            String toOpen = "Open";
            if (ret == JFileChooser.APPROVE_OPTION) {
                toOpen = fileChooser.getSelectedFile().getAbsolutePath();
            }

            File file = new File(toOpen);

            try {
                Import importer = new Import();
                Document docum = importer.importe(toOpen);

                TransformGraphic graf = new TransformGraphic();
                TransformNet tranNet = new TransformNet();

                CanvasNet canvas = new CanvasNet(graf.transform(tranNet.transform(docum), docum), docum, this);
                add(canvas,BorderLayout.CENTER);

                button1.setCanvasNet(canvas);
                button1.setElement(canvas.getElement());
                button1.setDokum(canvas.getDokum());

                
                setVisible(true);


            } catch (JAXBException ee) {
                ee.printStackTrace();
            } catch (FileNotFoundException ex) {
                System.out.println("nic sa nenacitalo");
            }
        }

        if (e.getSource() == SaveAsFile)
        {
            FileDialog SaveDialog = new FileDialog(this, "Uloz ako", FileDialog.SAVE);
            SaveDialog.setVisible(true);

            Export export = new Export();
            Document dokum;
            dokum = export.tranDokum(this.petrisNet);


                try {
                    JAXBContext context = JAXBContext.newInstance(Document.class);
                    Marshaller marshallerOb = context.createMarshaller();
                    marshallerOb.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marshallerOb.marshal(dokum, new FileOutputStream("new.xml"));
                }
                catch (Exception ees){
                    ees.printStackTrace();
                }


        }
    }
}