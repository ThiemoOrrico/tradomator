import styled from 'styled-components/macro'
import { convertToReadableDate } from '../service/date-service'
import {CCard, CCardBody, CCardImage, CCardText, CCardTitle, CCol, CRow} from "@coreui/react";

export default function CryptoCard({ coinData }) {
    return (

        <>
            {
                [
                { color: 'primary', textColor: 'white' }

                ].map((item, index) => (

                <CCard
                    color={item.color}
                    textColor={item.textColor}
                    className="mb-3"
                    style={{ maxWidth: '18rem' }}
                    key={index}
                >

                    <CRow className="g-0">
                        <CCol md={4}>
                            <CCardImage src={coinData?.imageUrl} alt={''} />
                        </CCol>

                        <CCol md={8}>
                            <CCardBody>
                                <CCardTitle>{item.color} {coinData?.name}</CCardTitle>
                                <CCardText> USD {coinData?.currentAvgPrice?.usd} </CCardText>

                                <CCardText>
                                    <small className="text-medium-emphasis"> {convertToReadableDate(coinData?.lastUpdated)} </small>
                                </CCardText>

                            </CCardBody>
                        </CCol>
                    </CRow>
                </CCard>
                ))
            }

        </>

    )
}


