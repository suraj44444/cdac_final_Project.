import React from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';

const Header = props =>{
    return (
      <Navbar bg="primary" variant="dark">
      <Container>
      <Navbar.Brand href="#home">Travelgram.com</Navbar.Brand>
      <Nav className="me-auto">
        <Nav.Link href="/">Home</Nav.Link>
        <br/>
        <Nav.Link href="/packageregistration">Package Registration</Nav.Link>
        <br/>
        <Nav.Link href="/dashboard">Dashboard</Nav.Link>
        <br/>
      </Nav>
      </Container>
    </Navbar>
    );
};
export default Header;
