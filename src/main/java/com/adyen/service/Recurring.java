/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.recurring.DisableRequest;
import com.adyen.model.recurring.DisableResult;
import com.adyen.model.recurring.NotifyShopperRequest;
import com.adyen.model.recurring.NotifyShopperResult;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.model.recurring.StoreTokenRequest;
import com.adyen.model.recurring.StoreTokenResult;
import com.adyen.model.recurring.ScheduleAccountUpdaterRequest;
import com.adyen.model.recurring.ScheduleAccountUpdaterResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.recurring.Disable;
import com.adyen.service.resource.recurring.ListRecurringDetails;
import com.adyen.service.resource.recurring.NotifyShopper;
import com.adyen.service.resource.recurring.ScheduleAccountUpdater;
import com.adyen.service.resource.recurring.StoreToken;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Recurring extends Service {
    private final ListRecurringDetails listRecurringDetails;
    private final Disable disable;
    private final StoreToken storeToken;
    private final ScheduleAccountUpdater scheduleAccountUpdater;
    private final NotifyShopper notifyShopper;

    public Recurring(Client client) {
        super(client);

        listRecurringDetails = new ListRecurringDetails(this);
        disable = new Disable(this);
        storeToken = new StoreToken(this);
        scheduleAccountUpdater = new ScheduleAccountUpdater(this);
        notifyShopper = new NotifyShopper(this);
    }

    /**
     * Issues a listRecurringDetails API call
     *
     * @param request RecurringDetailsResult
     * @return recurring details result
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public RecurringDetailsResult listRecurringDetails(RecurringDetailsRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = listRecurringDetails.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<RecurringDetailsResult>() {
        }.getType());
    }

    /**
     * Issues a disable recurring contract API call
     *
     * @param request DisableRequest
     * @return DisableResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public DisableResult disable(DisableRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = disable.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<DisableResult>() {
        }.getType());
    }

    /**
     * Issues a storeToken API call
     *
     * @param request StoreTokenRequest
     * @return StoreTokenResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public StoreTokenResult storeToken(StoreTokenRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = storeToken.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<StoreTokenResult>() {
        }.getType());
    }

    /**
     * Issues a scheduleAccountUpdate API call
     *
     * @param request ScheduleAccountUpdaterRequest
     * @return ScheduleAccountUpdaterResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ScheduleAccountUpdaterResult scheduleAccountUpdater(ScheduleAccountUpdaterRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = scheduleAccountUpdater.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<ScheduleAccountUpdaterResult>() {
        }.getType());
    }

    /**
     * Issues a notifyShopper API call
     *
     * @param request ScheduleAccountUpdaterRequest
     * @return ScheduleAccountUpdaterResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public NotifyShopperResult notifyShopper(NotifyShopperRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);
        String jsonResult = notifyShopper.request(jsonRequest);
        return GSON.fromJson(jsonResult, new TypeToken<NotifyShopperResult>() {
        }.getType());
    }

}
