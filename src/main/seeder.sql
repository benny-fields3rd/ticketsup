use tickets_db;

INSERT INTO users (email, first_name, is_admin, last_name, password, phone, username, zip_code) VALUES
                                    ('user@msn.com', 'Demo', false, 'Shukran', 'user', '(210)555-5555', 'user', 12345),
                                    ('admin@msn.com', 'Demo2', true, 'Afwan', 'admin', '(210)456-5678', 'admin', 54321);

INSERT INTO seats (name) VALUES
                                ('a1'), ('a2'), ('a3'), ('a4'), ('a5'), ('a6'), ('a7'), ('a8'), ('a9'), ('a10'), ('a11'),('a12'),
                                ('b1'), ('b2'), ('b3'), ('b4'), ('b5'), ('b6'), ('b7'), ('b8'), ('b9'), ('b10'), ('b11'),('b12'),
                                ('c1'), ('c2'), ('c3'), ('c4'), ('c5'), ('c6'), ('c7'), ('c8'), ('c9'), ('c10'), ('c11'),('c12'),
                                ('d1'), ('d2'), ('d3'), ('d4'), ('d5'), ('d6'), ('d7'), ('d8'), ('d9'), ('d10'), ('d11'),('d12'),
                                ('e1'), ('e2'), ('e3'), ('e4'), ('e5'), ('e6'), ('e7'), ('e8'), ('e9'), ('e10'), ('e11'),('e12'),
                                ('f1'), ('f2'), ('f3'), ('f4'), ('f5'), ('f6'), ('f7'), ('f8'), ('f9'), ('f10'), ('f11'),('f12'),
                                ('g1'), ('g2'), ('g3'), ('g4'), ('g5'), ('g6'), ('g7'), ('g8'), ('g9'), ('g10'), ('g11'),('g12'),
                                ('h1'), ('h2'), ('h3'), ('h4'), ('h5'), ('h6'), ('h7'), ('h8'), ('h9'), ('h10'), ('h11'),('h12'),
                                ('i1'), ('i2'), ('i3'), ('i4'), ('i5'), ('i6'), ('i7'), ('i8'), ('i9'), ('i10'), ('i11'),('i12'),
                                ('j1'), ('j2'), ('j3'), ('j4'), ('j5'), ('j6'), ('j7'), ('j8'), ('j9'), ('j10'), ('j11') ,('j12');

INSERT INTO food (name, price) VALUES
                                      ('burgers', 7.00),
                                      ('drinks', 3.00),
                                      ('pizza', 5.00),
                                      ('hot-dogs', 5.00),
                                      ('nachos', 5.00),
                                      ('popcorn', 5.00);

INSERT INTO status (status) VALUES
                                ('Movie Selection'), ('Seats Selection'), ('Food Selection'),  ('Order Placed');