import 'package:flutter/material.dart';
import 'login_page.dart';  // Import your login page

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,  // Hide the debug banner
      title: 'my_flutter_app',
      theme: ThemeData(
        primarySwatch: Colors.teal,  // Use teal theme color
      ),
      home: LoginPage(),  // Set LoginPage as the home screen
    );
  }
}
