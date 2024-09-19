import 'package:flutter/material.dart';
import 'login_page.dart';  // Import your login page file

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Login Page Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        useMaterial3: true,  // If you're using Material 3 design
      ),
      home: LoginPage(),  // Set LoginPage as the home screen
    );
  }
}
