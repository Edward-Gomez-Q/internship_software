import 'package:flutter/material.dart';

class HeaderPrincipal extends StatelessWidget {
  final Widget header;
  final Widget content;

  HeaderPrincipal({required this.header, required this.content});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity, // 100%
      decoration: BoxDecoration(
        gradient: LinearGradient(
          begin: Alignment.topCenter,
          colors: [
            Colors.blue.shade900,
            Colors.blue.shade800,
            Colors.blue.shade400,
          ],
        ),
      ),
      child: Column(
        children: <Widget>[
          SizedBox(
            height: 80,
          ),
          Row(
            children: [
              Expanded(
                  child: IconButton(
                icon: Icon(Icons.arrow_back_ios),
                color: Colors.white,
                onPressed: () {
                  Navigator.pop(context);
                },
              )),
              header,
            ],
          ),
          Expanded(
            child: Container(
              decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.only(
                      topLeft: Radius.circular(60),
                      topRight: Radius.circular(60))),
              child: content,
            ),
          ),
        ],
      ),
    );
  }
}
