/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.escalade.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple domain object representing a list of Users. Mostly here to be used for the 'Admins' {@link
 * org.springframework.web.servlet.view.xml.MarshallingView}.
 *
 * @author Guillaume Nivet
 */
@XmlRootElement
public class Admins {

    private List<Admin> admins;

    @XmlElement
    public List<Admin> getAdminrList() {
        if (admins == null) {
            admins = new ArrayList<>();
        }
        return admins;
    }

}
