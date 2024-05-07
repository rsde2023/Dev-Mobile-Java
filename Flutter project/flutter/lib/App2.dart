import 'package:flutter/material.dart';

class App2 extends StatelessWidget {
  const App2({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.pinkAccent,
          title: const Text(
            "App Bar 2",
            style: TextStyle(color: Colors.white),
          ),
        ),
        body: Center(
          child: Container(
            padding: const EdgeInsets.all(10),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(12),
              border: Border.all(
                color: Colors.pinkAccent,
                width: 8,
              )
            ),
            child: const Text("Hello world!",style: TextStyle(color: Colors.blueAccent),),
          ),
        ),
      ),
    );
  }
}
