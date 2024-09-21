import 'package:flutter/material.dart';

class LoginPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            // Logo and Name
            Column(
              children: [
                Image.asset(
                  'assets/images/logo.png', // Path to the image
                  height: 200, // You can adjust the height based on your needs
                ),
                const SizedBox(height: 10),
                const Text(
                  'MINESYNC',
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                    color: Colors.teal,
                  ),
                ),
              ],
            ),
            const SizedBox(height: 50),

            // "Choose your role" text
            const Text(
              'Choose your role',
              style: TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.w600,
                color: Colors.teal,
              ),
            ),
            const SizedBox(height: 40),

            // Admin Button
            _roleButton(context, "Admin"),
            const SizedBox(height: 20),

            // Supervisor Button
            _roleButton(context, "Supervisor"),

            const SizedBox(height: 40),

            // Login Options Text
            GestureDetector(
              onTap: () {
                // Add action for login options if needed
              },
              child: const Text(
                'Login Options',
                style: TextStyle(
                  fontSize: 16,
                  color: Colors.teal,
                  decoration: TextDecoration.underline,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _roleButton(BuildContext context, String role) {
    return ElevatedButton.icon(
      onPressed: () {
        debugPrint("$role login clicked");
        // Add navigation to respective login page
      },
      icon: const Icon(Icons.person, color: Colors.white),
      label: Text(role),
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.teal, // Use backgroundColor instead of primary
        foregroundColor: Colors.white, // Use foregroundColor instead of onPrimary
        minimumSize: const Size(double.infinity, 60),
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(30),
        ),
      ),
    );
  }
}
