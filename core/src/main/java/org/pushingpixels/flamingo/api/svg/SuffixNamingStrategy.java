/**
 * Copyright 2011 Emmanuel Bourg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pushingpixels.flamingo.api.svg;

import java.io.File;

/**
 * Add a suffix to the name generated by another naming strategy.
 * The suffix is not added if the name already ends with it.
 * 
 * @author Emmanuel Bourg
 * @version $Revision$, $Date$
 */
public class SuffixNamingStrategy implements NamingStrategy {

    private final NamingStrategy strategy;
    private final String suffix;

    public SuffixNamingStrategy(NamingStrategy strategy, String suffix) {
        this.strategy = strategy;
        this.suffix = suffix;
    }

    public String getClassName(File file) {
        String name = strategy.getClassName(file);
        if (!name.endsWith(suffix)) {
            name += suffix;
        }
        return name;
    }
}
