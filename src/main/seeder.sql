use tickets_db;

INSERT INTO users (email, first_name, is_admin, last_name, password, phone, username, zip_code) VALUES
                                    ('user@msn.com', 'Demo', false, 'Shukran', 'user', '(210)555-5555', 'user', 12345),
                                    ('admin@msn.com', 'Demo2', true, 'Afwan', 'admin', '(210)456-5678', 'admin', 54321);

INSERT INTO seats (name) VALUES
                                ('A1'), ('A2'), ('A3'), ('A4'), ('A5'), ('A6'),
                                ('B1'), ('B2'), ('B3'), ('B4'), ('B5'), ('B6'),
                                ('C1'), ('C2'), ('C3'), ('C4'), ('C5'), ('C6'),
                                ('D1'), ('D2'), ('D3'), ('D4'), ('D5'), ('D6'),
                                ('E1'), ('E2'), ('E3'), ('E4'), ('E5'), ('E6'),
                                ('F1'), ('F2'), ('F3'), ('F4'), ('F5'), ('F6'),
                                ('G1'), ('G2'), ('G3'), ('G4'), ('G5'), ('G6'),
                                ('H1'), ('H2'), ('H3'), ('H4'), ('H5'), ('H6'),
                                ('I1'), ('I2'), ('I3'), ('I4'), ('I5'), ('I6'),
                                ('J1'), ('J2'), ('J3'), ('J4'), ('J5'), ('J6'),
                                ('K1'), ('K2'), ('K3'), ('K4'), ('K5'), ('K6'),
                                ('L1'), ('L2'), ('L3'), ('L4'), ('L5'), ('L6'),
                                ('M1'), ('M2'), ('M3'), ('M4'), ('M5'), ('M6'),
                                ('N1'), ('N2'), ('N3'), ('N4'), ('N5'), ('N6'),
                                ('O1'), ('O2'), ('O3'), ('O4'), ('O5'), ('O6'),
                                ('P1'), ('P2'), ('P3'), ('P4'), ('P5'), ('P6');



INSERT INTO food (name, price) VALUES
                                      ('burgers', 7.00),
                                      ('drinks', 3.00),
                                      ('pizza', 5.00),
                                      ('hot-dogs', 5.00),
                                      ('nachos', 5.00),
                                      ('popcorn', 5.00);

INSERT INTO status (status) VALUES
                                ('Movie Selection'), ('Seats Selection'), ('Food Selection'),  ('Order Placed');