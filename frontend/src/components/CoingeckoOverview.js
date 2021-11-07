import CryptoCard from './CryptoCard'
import styled from 'styled-components/macro'


export default function CoingeckoOverview({ coins }) {

    return (
        <Wrapper>
            {coins.map(coin => (
                <CryptoCard key={coin.id} coinData={coin} />
            ))}
        </Wrapper>
    )
}

const Wrapper = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 450px));
  grid-gap: 10px;
`
