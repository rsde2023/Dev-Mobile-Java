import 'package:flutter/material.dart';

class App3 extends StatelessWidget {
  const App3({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text('3eme App Flutter'),
          backgroundColor: const Color.fromRGBO(14, 112, 20, 100),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset('1.jpg'),
              const SizedBox(height:10,),
              const Text("APP 3"),
            ],
          ),
        ),
      ),
    );
  }
}
