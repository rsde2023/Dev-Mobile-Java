import 'package:flutter/material.dart';

class App4 extends StatelessWidget {
  const App4({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text("4eme Application"),
          backgroundColor: Colors.blueAccent,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(
                child: Image.asset(
                  "2.jpg",
                  fit: BoxFit.fill,
                  width: 350,
                ),
              ),
              const Text("App 4"),
            ],
          ),
        ),
      ),
    );
  }
}
