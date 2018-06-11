Alert alert = new Alert(Alert.AlertType.ERROR, "Ciao", ButtonType.OK);
Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    // do something
}


TextInputDialog dialog = new TextInputDialog();
Optional<String> result2 = dialog.showAndWait();
result2.ifPresent(name -> {
    /* Do things with name (content)*/ });
    
// Con Polygon si mettono a coppie i punti in getPoints()
Polygon poly = new Polygon();
poly.getPoints().addAll(new Double[]{
    x, y,
    x + size, y,
    x + size / 2.0, y - (size * Math.sqrt(3) / 2.0)}); // Triangolo

// Rotazione rispetto al centro
Rotate rot = new Rotate(45, x, y);
rombo.getTransforms().add(rot);

// Centrare una figura creata con coordinate
super(x - size / 2, y - size / 2, ...);

// Uso dei keycode
primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
    switch (e.getCode()) {
        case C:
            break;
        case DIGIT0:
            break;
        // ... vedi suggerimenti IDE
    }
});

// Concurrency 
Thread thr = new Thread() {
    @Override
    public void run() {
        // Do stuff
    }
};
thr.start();
thr.interrupt();

// Codice per sbolognare codice al thread principale quando possibile
Platform.runLater(() -> {
    /* Do something on main thread */
});

// Sfondi e bordi di un Pane
root.setBackground(new Background(new BackgroundFill(Color.WHITE,
        CornerRadii.EMPTY, Insets.EMPTY)));
root.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
        BorderWidths.DEFAULT)));

// Equals
boolean res = false;
if (o != null & o instanceof Coordinate) {
    if (/* TEST VARI ED EVENTUALI CHE DANNO*/true) {
        res = true;
    }
}
// Usare getClass() se la classe possiede delle classi figlie
// instanceof se non ne possiede 
// HashCode: Premere Alt-Ins e lasciarlo generare a NetBeans

// Layout "liquidi"
ColumnConstraints column1 = new ColumnConstraints();
ColumnConstraints column2 = new ColumnConstraints();
column1.setPercentWidth(70);
column2.setPercentWidth(30);
column1.setHgrow(Priority.ALWAYS); // Priorità alla crescita
root.getColumnConstraints().addAll(column1, column2);

RowConstraints row1 = new RowConstraints();
row1.setPercentHeight(100);
root.getRowConstraints().add(row1);

// Listener per property
field.textProperty().addListener(
        (ObservableValue<? extends String> observable,
                String oldValue, String newValue) -> {
            // Do things with the listener
        });

// HBox, VBox, StackPane sono relativamente semplici; inoltre abbiamo
// TitledPane e Accordion

// The TilePane class places its content nodes in uniformly sized
// layout or tiles        
tilePane.setPrefColumns(2);

// The FlowPane class arranges its content nodes in either a
// horizontal or vertical “flow”, wrapping at the specified width
//(for horizontal) or height (for vertical) boundaries.        
flowPane.setPrefWrapLength(100);

// The BorderPane class lays out its content nodes in the top,
// bottom, right, left, or center region.        
BorderPane.setAlignment(child, Pos.TOP_CENTER); // per allineare nel box
borderPane.setTop(child); //... etc

// The AnchorPane class enables developers to create anchor nodes to the
// top, bottom, left side, or center of the layout.
AnchorPane.setBottomAnchor(node, 8.0); // distanza dal bordo (static!)

// The GridPane class enables the developer to create a flexible
// grid of rows and columns in which to lay out content nodes
// Vedi ColumnConstraint sopra; inoltre abbiamo
GridPane.setConstraints(node, columnIndex, rowIndex,
        columnSpan, rowSpan);




// Animazioni
Transition animation = new Transition() {
    { setCycleDuration(Duration.millis(2000)); }
    protected void interpolate(double frac) {
        final int length = content.length();
        final int n = Math.round(length * (float) frac);
        text.setText(content.substring(0, n));
    }};

// Transition: elementi di base
transition.setCycleCount(Timeline.INDEFINITE);
transition.setAutoReverse(true);
transition.play();

// FadeTransition
FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
ft.setFromValue(1.0);
ft.setToValue(0.0);

// PathTransition ncessita di una path per poter funzionare.
PathTransition pathTransition = new PathTransition();
pathTransition.setDuration(Duration.millis(4000));
pathTransition.setPath(path);
pathTransition.setNode(shape);
pathTransition.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

// Per creare la Path, generiamone una vuota e aggiungiamo elementi
Path path = new Path();
path.getElements().add(arcTo, hLineTo); // etc

// Movimento ad arco con raggio fissato
ArcTo arcTo = new ArcTo();
arcTo.setX(50.0f);
arcTo.setY(50.0f);
arcTo.setRadiusX(50.0f);
arcTo.setRadiusY(50.0f);
// Linea dritta orizzontale o verticale

HLineTo hLineTo = new HLineTo();
hLineTo.setX(70.0f);

// Linea anche storta
LineTo lineTo = new LineTo();
lineTo.setX(175.0f);
lineTo.setY(105.0f);

// Spostamento secco verso una coordinata
MoveTo moveTo = new MoveTo();
moveTo.setX(0.0f);
moveTo.setY(0.0f);

// 1 punto di Bezier per il controllo della curva
QuadCurveTo quadTo = new QuadCurveTo();
quadTo.setControlX(0.0f);
quadTo.setControlY(0.0f);
quadTo.setX(100.0f);
quadTo.setY(50.0f);


// 1, 2 punti di Bezier per il controllo della curva
CubicCurveTo cubicTo = new CubicCurveTo();
cubicTo.setControlX1(0.0f);
cubicTo.setControlY1(0.0f);
cubicTo.setControlX2(100.0f);
cubicTo.setControlY2(100.0f);
cubicTo.setX(100.0f);
cubicTo.setY(50.0f);

// Timeline: bisogna aggiungere dei KeyFrame (anche multipli)
// per animare l'oggetto in questione con regole definite 
// ogni keyframe ha durata data alla creazione
Timeline tl = new Timeline();
KeyFrame moveBall = new KeyFrame(Duration.seconds(1),
        new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // do things
            }});
tl.getKeyFrames().add(moveBall);

// Transizioni concorrenti
SequentialTransition sq = new SequentialTransition(fadeTransition,
        translateTransition);
ParallelTransition pt = new ParallelTransition(/* ... */);
    }
    
// Ricerca di un elemento in GridPane
public Node standardGetElementAt(int i, int j) {
    Node res = null;
    for (Node x : getChildren()) {
        if (GridPane.getRowIndex(x) == i && GridPane.getColumnIndex(x) == j) {
            res = x;
            break;
        }
    }
    return res;  
}

root.setPadding(new Insets(20, 20, 20, 20)); // spazio tra il resto
root.setHgap(10); // GridPane per lo spazio tra i node
root.setVgap(10);

// Ottenere colore in background
getBackground().getFills().get(0).getFill().equals(Color.WHITE)

// Punti di costruzione di un "+"
getPoints().addAll(
    x, y,
    x, y + size / 2,
    x - size / 6, y + size / 2,
    x - size / 6, y,
    x - size / 6 - size / 2, y,
    x - size / 6 - size / 2, y - size / 6,
    x - size / 6, y - size / 6,
    x - size / 6, y - size / 6 - size / 2,
    x, y - size / 6 - size / 2,
    x, y - size / 6,
    x + size / 2, y - size / 6,
    x + size / 2, y
);

// Varie ed eventuali
System.arraycopy(Object src, int srcPos,
Object dest, int destPos, int length);
System.currentTimeMillis();		// restituisce un long dalla epoca Unix

// Parsing sample
Integer.parseint(string);		
Float.parseFloat(string);
String.charAt(0);				

// Iterator sample
Iterator i = x.iterator();
while (i.hasNext()) {
if (!cond(i.next())) {
    i.remove();
}

// Riga di comando (compile, run, jar)
// javac -verbose -sourcepath "src/" -d
//     "build/classes/" "src/it/unitn/prog2/HelloWorldApp.java"
//
// java -verbose -classpath build/classes it.unitn.prog2.HelloWorldApp args
// 
// jar cfe HelloWorldApp.jar it.unitn.prog2.HelloWorldApp
//      -C build/classes/ it/unitn/prog2/HelloWorldApp.class