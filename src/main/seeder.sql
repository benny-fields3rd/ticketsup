use tickets_db;

INSERT INTO seats (name) VALUES
                                ('a1'), ('a2'), ('a3'), ('a4'), ('a5'), ('a6'), ('a7'), ('a8'),
                                ('b1'), ('b2'), ('b3'), ('b4'), ('b5'), ('b6'), ('b7'), ('b8'),
                                ('c1'), ('c2'), ('c3'), ('c4'), ('c5'), ('c6'), ('c7'), ('c8'),
                                ('d1'), ('d2'), ('d3'), ('d4'), ('d5'), ('d6'), ('d7'), ('d8'),
                                ('e1'), ('e2'), ('e3'), ('e4'), ('e5'), ('e6'), ('e7'), ('e8'),
                                ('f1'), ('f2'), ('f3'), ('f4'), ('f5'), ('f6'), ('f7'), ('f8'),
                                ('g1'), ('g2'), ('g3'), ('g4'), ('g5'), ('g6'), ('g7'), ('g8'),
                                ('h1'), ('h2'), ('h3'), ('h4'), ('h5'), ('h6'), ('h7'), ('h8'),
                                ('i1'), ('i2'), ('i3'), ('i4'), ('i5'), ('i6'), ('i7'), ('i8'),
                                ('j1'), ('j2'), ('j3'), ('j4'), ('j5'), ('j6'), ('j7'), ('j8'),('j9');

INSERT INTO food (name, price) VALUES
                                      ('burgers', 7.00),
                                      ('drinks', 3.00),
                                      ('pizza', 5.00),
                                      ('hot-dogs', 5.00),
                                      ('nachos', 5.00),
                                      ('popcorn', 5.00);

INSERT INTO status (status) VALUES
                                ('Movie Selection'), ('Seats Selection'), ('Food Selection'),  ('Order Placed');