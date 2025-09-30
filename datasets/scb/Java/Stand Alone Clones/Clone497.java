public class Clone497 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:41514223
*  Stack Overflow answer #:41622251
*  And Stack Overflow answer#:41628357
*/
protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.buttons);
    initializeLookup ();
    mEditText = (EditText) findViewById (R.id.edit_text);
    mButton00 = (Button) findViewById (R.id.button_0_0);
    mButton10 = (Button) findViewById (R.id.button_1_0);
    mButton01 = (Button) findViewById (R.id.button_0_1);
    mButton11 = (Button) findViewById (R.id.button_1_1);
    mButton02 = (Button) findViewById (R.id.button_0_2);
    mButton12 = (Button) findViewById (R.id.button_1_2);
    mButton00.setOnClickListener (this);
    mButton10.setOnClickListener (this);
    mButton01.setOnClickListener (this);
    mButton11.setOnClickListener (this);
    mButton02.setOnClickListener (this);
    mButton12.setOnClickListener (this);
    mHandleInputRunnable = new Runnable () {
        @Override
        public void run () {
            handleAlarmTrigger ();
        }}
    ;
}

protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main);
    Window window = this.getWindow ();
    window.addFlags (WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    window.addFlags (WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    window.addFlags (WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    txtMessage = (TextView) findViewById (R.id.txtMesssage);
    Button buttonOne = (Button) findViewById (R.id.block1);
    Button buttonTwo = (Button) findViewById (R.id.block2);
    Button buttonThree = (Button) findViewById (R.id.block3);
    Button buttonFour = (Button) findViewById (R.id.block4);
    Button buttonFive = (Button) findViewById (R.id.block5);
    Button buttonSix = (Button) findViewById (R.id.block6);
    buttonOne.setOnClickListener (this);
    buttonTwo.setOnClickListener (this);
    buttonThree.setOnClickListener (this);
    buttonFour.setOnClickListener (this);
    buttonFive.setOnClickListener (this);
    buttonSix.setOnClickListener (this);
}

}
