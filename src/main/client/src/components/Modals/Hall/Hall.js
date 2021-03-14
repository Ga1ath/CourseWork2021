import React, { useEffect, useRef } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { hideHallPopup } from "../../../actions/hallPopup";

import "./styles.css"
import Row from './Row/Row';

const Hall = () => {
	let visible = useSelector(state => state.hallPopup.visible);
	let seats = useSelector(state => state.currentSession);
	const ref = useRef();
	const dispatch = useDispatch();

	const clickHandler = (event) => {
		!event.path.includes(ref.current) && dispatch(hideHallPopup());
	}

	useEffect(() => {
		document.addEventListener('click', clickHandler);
		return () => {
			document.removeEventListener('click', clickHandler);
		}
	}, [])


	return (
		<div ref={ref} className="hall">
			{seats.map((row, key) => {
				return (
					<Row row={row} id={key} />
				)
			})}
		</div>
	)
}

export default Hall;