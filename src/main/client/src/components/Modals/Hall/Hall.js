import React, { useEffect, useRef } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { hideHallPopup } from "../../../actions/hallPopup";

import "./styles.css"

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
			{seats.map(seat => {
				return <div>{seat}</div>
			})}
		</div>
	)
}

export default Hall;