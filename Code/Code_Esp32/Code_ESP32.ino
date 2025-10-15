void setup(){
 Serial.begin(9600);
 Serial2.begin(9600, SERIAL_8N1, RXp2, TXp2);
 if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println(F("SSD1306 allocation failed"));
 for (;;);
 }
 display.display();
 WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
 Serial.print("Connecting to Wi-Fi");
 while (WiFi.status() != WL_CONNECTED){
 Serial.print(".");
 delay(300);
 }
 Serial.println();
 Serial.print("Connected with IP: ");
 Serial.println(WiFi.localIP());
 Serial.println();
 config.api_key = API_KEY;
 config.database_url = DATABASE_URL;
 if (Firebase.signUp(&config, &auth, "", "")){
 Serial.println("ok");
 signupOK = true;
 }
 else
 Serial.printf("%s\n", config.signer.signupError.message.c_str());
 config.token_status_callback = tokenStatusCallback;
 Firebase.begin(&config, &auth);
 Firebase.reconnectWiFi(true);
 delay(5000);
}
void send_data_firebase () {
if (Firebase.ready() && signupOK && (millis() - sendDataPrevMillis > 
15000 || sendDataPrevMillis == 0)){
 sendDataPrevMillis = millis();
 if (Firebase.RTDB.setInt(&fbdo, "xe1/onbus", so_hoc_sinh)){
 Serial.println("PASSED" );
 Serial.println("PATH: " + fbdo.dataPath());
 Serial.println("TYPE: " + fbdo.dataType());
 }
 else {
 Serial.println("FAILED");
 Serial.println("REASON: " + fbdo.errorReason());
 }
 }
}

void loop() {
  if (Serial2.available() > 0) {
    so_hoc_sinh = Serial2.parseInt(); // Đọc giá trị được gửi từ Board Arduino 
    Serial.print("Number of students: ");
    Serial.println(so_hoc_sinh); // In giá trị đã nhận lên Serial Monitor
 }
  Serial.print("Number of students: ");
 Serial.println(so_hoc_sinh);
 display.clearDisplay(); 
 display.setTextSize(1); 
 display.setTextColor(WHITE); 
 display.setCursor(0, 0); 
 display.print(F("Number of students:")); 
 display.println(so_hoc_sinh); 
 display.display(); 
 send_data_firebase();
 delay(500);
}
