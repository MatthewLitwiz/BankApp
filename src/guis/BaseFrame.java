package guis;

import javax.swing.JFrame;

import db_objs.User;


/*
    Creating an abstract class helps us setup the blueprint that our GUIs will follow, for example
    in each of the GUIs they will be the same size and will need to invoke their own addGuiComponents()
    which will be unique to each subclass
 */

 public abstract class BaseFrame extends JFrame {
    // store user information
    protected User user;

    public BaseFrame(String title){ // overriding constructors
        initialize(title);
    }
    public BaseFrame(String title, User user){
        // initialize user
        this.user = user;

        initialize(title);
    }

    private void initialize(String title){
        // instantiate the frame properties and add title to the bar
        setTitle(title);

        // set size (in pixels)
        setSize(420, 600);

        // terminate program when the gui is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set layout to null to have absolute layout which allows us to manually specify the size and position of each gui component
        setLayout(null);

        // prevent gui from being resized
        setResizable(false);

        // launch the gui in the center of the screen
        setLocationRelativeTo(null);

        // call on the subclass' addGuiComponents() method
        addGuiComponents();

    }

    // this method will be unique to each subclass so defined in those class that is inheriting it
    protected abstract void addGuiComponents();


}
