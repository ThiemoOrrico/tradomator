import { DiAptana } from "react-icons/di";

import Navbar from './ButtonAppBar'
import styled from 'styled-components'

function Header() {
    return (
        <HeaderContainer>

            <Navbar />
        </HeaderContainer>


    )
}
export default Header

const HeaderContainer = styled.section`
  display: grid;
  grid-template-columns: min-content 1fr;
  justify-content: space-between;
  align-items: center;
  background-color: steelblue;
  font-family: 'Montserrat', sans-serif;
  font-size: 30px;

`

const Logo = styled(DiAptana)`
  font-size: 60px;
  color: white;
`
