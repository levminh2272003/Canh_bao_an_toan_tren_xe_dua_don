//1. Phần đăng ký
private void registerUser(String email, String password) {
 auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() { 
     @Override
 public void onComplete(@NonNull Task<AuthResult> task) {
 if (task.isSuccessful()) {
 // Sign in success, update UI with the signed-in user's information
 //FirebaseUser user = mAuth.getCurrentUser();
 Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công.", Toast.LENGTH_SHORT).show();
 Intent intent = new Intent(getApplicationContext(),PeoDisplayActivity.class);
 startActivity(intent);
 finish();
 } else {
 // If sign in fails, display a message to the user.
 Toast.makeText(RegisterActivity.this, "Tạo tài khoản thất bại.", 
Toast.LENGTH_SHORT).show();
 }
 }
 });
 }
 
 
//2. Phần đăng nhập
private void loginUser(String email, String password) {
 auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() 
{
 @Override
 public void onComplete(@NonNull Task<AuthResult> task) {
 if (task.isSuccessful()) {
 Toast.makeText(LoginActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
 Intent intent = new Intent(getApplicationContext(),PeoDisplayActivity.class);
 startActivity(intent);
 finish();
 } else {
 Toast.makeText(LoginActivity.this, "Email hoặc mật khẩu không chính xác.", Toast.LENGTH_SHORT).show();
 }
 }
 });
 }


//3. Đọc dữ liệu từ Firebase
private void readDatabaseN(TextView display_data, String child, String parent){
 // Read from the database
 FirebaseDatabase database = FirebaseDatabase.getInstance();
 DatabaseReference myRef = database.getReference(parent).child(child);
 myRef.addValueEventListener(new ValueEventListener() {
 @Override 
 public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
 // This method is called once with the initial value and again
 // whenever data at this location is updated.
 Integer value = dataSnapshot.getValue(Integer.class);
 // Hiển thị giá trị lên TextView
 display_data.setText(String.valueOf(value));
 }
 @Override
 public void onCancelled(@NonNull DatabaseError error) {
 // Failed to read value
 }
 });
 }