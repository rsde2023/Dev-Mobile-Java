import 'package:flutter/material.dart';

class App5 extends StatelessWidget {
  final List liste = List.generate(1000, (index){
    return{
      "id": index,
      "title": "this is the title $index",
      "subtitle" : "this is the subtitle $index"
    };
  });


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text(
            ('5eme Application'),
          ),
        ),
        body: ListView.builder(
          itemCount: liste.length,
          itemBuilder: (context, index) =>Card(
            elevation: 6,
            child:ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.pinkAccent,
                child: Text(liste[index]["id"].toString()),
              ),
              title: Text(liste[index]["title"]),
              subtitle: Text(liste[index]["subtitle"]),
              trailing: const Icon(Icons.add_link),
            ),
          )

        ),
      ),
    );
  }
}
