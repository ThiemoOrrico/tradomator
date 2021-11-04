import styled from "styled-components/macro";
import CoingeckoOverview from "./CoingeckoOverview";
import useGeckoCoins from "../hooks/useGeckoCoins";

export default function TempCardOverview() {

    const { coins, setCoins, getCoinById, getStandardCoins, isInList } =
        useGeckoCoins()

    return (


          <div>

                <CoingeckoOverview coins={coins} />

          </div>

    )
}

const PageLayout = styled.div`
  overflow: auto;
  position: fixed;
  height: 100%;
  width: 100%;
  top: 0;
  left: 0;
`
